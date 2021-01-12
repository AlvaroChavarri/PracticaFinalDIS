package back;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
public class PeliculaEditor extends VerticalLayout implements KeyNotifier {
    private PeliculaRepository repository;
    private Pelicula pelicula;
    TextField titulo = new TextField("titulo");
    TextField sinopsis = new TextField("sinopsis");
    TextField genero = new TextField("genero");
    TextField enlace = new TextField("enlace");
    TextField duracion = new TextField("duracion");
    TextField estreno = new TextField("estreno");
    Button save =new Button("Save",VaadinIcon.CHECK.create());
    Button delete =new Button("Delete",VaadinIcon.CHECK.create());
    Button cancel =new Button("Cancel");
    Binder<Pelicula> binder=new Binder<>(Pelicula.class);

    public PeliculaEditor(PeliculaRepository repository){
        this.repository=repository;
        add(titulo,sinopsis,genero,enlace,duracion,estreno);
        binder.bindInstanceFields(this);
        setSpacing(true);
        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");
        addKeyPressListener(Key.ENTER,e->save());
        save.addClickListener(e->save());
        delete.addClickListener(e->delete());
        //cancel.addClickListener(e->editPelicula(pelicula));
    }

    void delete() {
        repository.delete(pelicula);
        //changeHandler.onChange();
    }
    void save() {
        repository.save(pelicula);
        //changeHandler.onChange();
    }

}
