package vaadinarchetypeapplication.views.editarpelicula;

import java.util.Optional;

import vaadinarchetypeapplication.data.entity.Film;
import vaadinarchetypeapplication.data.service.FilmService;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.helpers.CrudServiceDataProvider;
import vaadinarchetypeapplication.views.main.MainView;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.textfield.TextField;

@Route(value = "edicion", layout = MainView.class)
@PageTitle("EditarPelicula")
@JsModule("./src/views/editarpelicula/editar-pelicula-view.js")
@Tag("editar-pelicula-view")
public class EditarPeliculaView extends PolymerTemplate<TemplateModel> {

    // This is the Java companion file of a design
    // You can find the design file in
    // /frontend/src/views/src/views/editarpelicula/editar-pelicula-view.js
    // The design can be easily edited by using Vaadin Designer
    // (vaadin.com/designer)

    private Grid<Film> grid;

    @Id
    private TextField titulo;
    @Id
    private TextField sinopsis;
    @Id
    private TextField genero;
    @Id
    private TextField duracion;
    @Id
    private DatePicker estreno;
    @Id
    private TextField enlace;

    @Id
    private Button cancel;
    @Id
    private Button save;

    private BeanValidationBinder<Film> binder;

    private Film film;

    public EditarPeliculaView(@Autowired FilmService filmService) {
        setId("editar-pelicula-view");

        // Grid is created here so we can pass the class to the constructor
        grid = new Grid<>(Film.class, false);
        grid.addColumn("titulo").setAutoWidth(true);
        grid.addColumn("sinopsis").setAutoWidth(true);
        grid.addColumn("genero").setAutoWidth(true);
        grid.addColumn("duracion").setAutoWidth(true);
        grid.addColumn("estreno").setAutoWidth(true);
        grid.addColumn("enlace").setAutoWidth(true);

        grid.setDataProvider(new CrudServiceDataProvider<>(filmService));
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setHeightFull();
        // Add to the `<slot name="grid">` defined in the template
        grid.getElement().setAttribute("slot", "grid");
        getElement().appendChild(grid.getElement());

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                Optional<Film> filmFromBackend = filmService.get(event.getValue().getId());
                // when a row is selected but the data is no longer available, refresh grid
                if (filmFromBackend.isPresent()) {
                    populateForm(filmFromBackend.get());
                } else {
                    refreshGrid();
                }
            } else {
                clearForm();
            }
        });

        // Configure Form
        binder = new BeanValidationBinder<>(Film.class);

        // Bind fields. This where you'd define e.g. validation rules

        binder.bindInstanceFields(this);

        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.film == null) {
                    this.film = new Film();
                }
                binder.writeBean(this.film);

                filmService.update(this.film);
                clearForm();
                refreshGrid();
                Notification.show("Film details stored.");
            } catch (ValidationException validationException) {
                Notification.show("An exception happened while trying to store the film details.");
            }
        });
    }

    private void refreshGrid() {
        grid.select(null);
        grid.getDataProvider().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(Film value) {
        this.film = value;
        binder.readBean(this.film);

    }
}
