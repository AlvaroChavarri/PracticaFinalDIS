package vaadinarchetypeapplication.views.formulario;


import vaadinarchetypeapplication.data.entity.Film;
import vaadinarchetypeapplication.data.service.FilmService;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import vaadinarchetypeapplication.views.main.MainView;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.Component;

/**
 * A Designer generated component for the formulario-view template.
 *
 * Designer will add and remove fields with @Id mappings but does not overwrite
 * or otherwise change this file.
 */
@Route(value = "formulario", layout = MainView.class)
@PageTitle("Formulario")
@JsModule("./src/views/formulario/formulario-view.js")
@Tag("formulario-view")
public class FormularioView extends PolymerTemplate<TemplateModel> {

    @Id("titulo")
    private TextField titulo;
    @Id("sinopsis")
    private TextField sinopsis;
    @Id("genero")
    private TextField genero;
    @Id("enlace")
    private TextField enlace;
    @Id("estreno")
    private DatePicker estreno;
    @Id("duracion")
    private TextField duracion;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    private Binder<Film> binder = new Binder(Film.class);

    public FormularioView(FilmService filmService) {

        binder.bindInstanceFields(this);
        clearForm();

        cancel.addClickListener(e -> clearForm());
        save.addClickListener(e -> {
            filmService.update(binder.getBean());
            Notification.show("Film details stored.");
            clearForm();
        });
    }

    private void clearForm() {
        binder.setBean(new Film());
    }

}
