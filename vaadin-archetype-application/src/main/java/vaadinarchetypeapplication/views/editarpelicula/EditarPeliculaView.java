package vaadinarchetypeapplication.views.editarpelicula;

import java.util.Optional;

import vaadinarchetypeapplication.data.entity.Person;
import vaadinarchetypeapplication.data.service.PersonService;

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

    private Grid<Person> grid;

    @Id
    private TextField firstName;
    @Id
    private TextField lastName;
    @Id
    private TextField email;
    @Id
    private TextField phone;
    @Id
    private DatePicker dateOfBirth;
    @Id
    private TextField occupation;
    @Id
    private Checkbox important;

    @Id
    private Button cancel;
    @Id
    private Button save;

    private BeanValidationBinder<Person> binder;

    private Person person;

    public EditarPeliculaView(@Autowired PersonService personService) {
        setId("editar-pelicula-view");

        // Grid is created here so we can pass the class to the constructor
        grid = new Grid<>(Person.class, false);
        grid.addColumn("firstName").setAutoWidth(true);
        grid.addColumn("lastName").setAutoWidth(true);
        grid.addColumn("email").setAutoWidth(true);
        grid.addColumn("phone").setAutoWidth(true);
        grid.addColumn("dateOfBirth").setAutoWidth(true);
        grid.addColumn("occupation").setAutoWidth(true);
        TemplateRenderer<Person> importantRenderer = TemplateRenderer.<Person>of(
                "<iron-icon hidden='[[!item.important]]' icon='vaadin:check' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: var(--lumo-primary-text-color);'></iron-icon><iron-icon hidden='[[item.important]]' icon='vaadin:minus' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: var(--lumo-disabled-text-color);'></iron-icon>")
                .withProperty("important", Person::isImportant);
        grid.addColumn(importantRenderer).setHeader("Important").setAutoWidth(true);

        grid.setDataProvider(new CrudServiceDataProvider<>(personService));
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setHeightFull();
        // Add to the `<slot name="grid">` defined in the template
        grid.getElement().setAttribute("slot", "grid");
        getElement().appendChild(grid.getElement());

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                Optional<Person> personFromBackend = personService.get(event.getValue().getId());
                // when a row is selected but the data is no longer available, refresh grid
                if (personFromBackend.isPresent()) {
                    populateForm(personFromBackend.get());
                } else {
                    refreshGrid();
                }
            } else {
                clearForm();
            }
        });

        // Configure Form
        binder = new BeanValidationBinder<>(Person.class);

        // Bind fields. This where you'd define e.g. validation rules

        binder.bindInstanceFields(this);

        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.person == null) {
                    this.person = new Person();
                }
                binder.writeBean(this.person);

                personService.update(this.person);
                clearForm();
                refreshGrid();
                Notification.show("Person details stored.");
            } catch (ValidationException validationException) {
                Notification.show("An exception happened while trying to store the person details.");
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

    private void populateForm(Person value) {
        this.person = value;
        binder.readBean(this.person);

    }
}
