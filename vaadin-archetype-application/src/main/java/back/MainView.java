package back;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.springframework.util.StringUtils;


public class MainView extends VerticalLayout {
    private PeliculaRepository repo;
    private PeliculaEditor editor;
    Grid<Pelicula> grid;
    final TextField filter;
    private final Button addNewBtn;

    public MainView(PeliculaRepository repo, PeliculaEditor editor){
        this.filter=new TextField();
        this.addNewBtn=new Button("Nueva pelicula");//Aqui falta una VaadinIcon.PLUS.create()
        grid.setHeight("300px");
        grid.setColumns("id","titulo","sinopsis","genero","enlace","duracion","estreno");
       // addNewBtn.addClickListener(e->editor.editPelicula(new Pelicula("","","","","","")));
        //editor.setChageHandler(()->{
           // editor.setVisible(false);
            listPelicula(filter.getValue());
        //});
    }

    private void listPelicula(String filterText) {
        if(StringUtils.isEmpty(filterText)){
           // grid.setItems(repo.findAll());
        }
        else{
            //grid.setItems(repo.findBytitulo(filterText));
        }
    }
}
