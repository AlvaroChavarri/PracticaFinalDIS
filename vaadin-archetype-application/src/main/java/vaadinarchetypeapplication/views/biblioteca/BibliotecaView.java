package vaadinarchetypeapplication.views.biblioteca;

import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.charts.model.XAxis;
import com.vaadin.flow.component.charts.model.YAxis;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import vaadinarchetypeapplication.views.biblioteca.BibliotecaView.BibliotecaViewModel;
import vaadinarchetypeapplication.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "biblioteca", layout = MainView.class)
@PageTitle("Biblioteca")
@JsModule("./src/views/biblioteca/biblioteca-view.js")
@Tag("biblioteca-view")
@RouteAlias(value = "", layout = MainView.class)
public class BibliotecaView extends PolymerTemplate<BibliotecaViewModel> implements AfterNavigationObserver {

    // This is the Java companion file of a design
    // You can find the design file in
    // /frontend/src/views/src/views/biblioteca/biblioteca-view.js
    // The design can be easily edited by using Vaadin Designer
    // (vaadin.com/designer)

    /**
     * All data we send to the client (template). Implementation is generated by the
     * framework.
     */
    public static interface BibliotecaViewModel extends TemplateModel {

        public void setItems(List<Client> items);
    }

    public BibliotecaView() {
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        // Set some data when this view is displayed.
        List<Client> clients = Arrays.asList(
                createClient(4957, "https://randomuser.me/api/portraits/women/42.jpg", "Amarachi Nkechi", 47427.0,
                        "Success", "2019-05-09"),
                createClient(675, "https://randomuser.me/api/portraits/women/24.jpg", "Bonelwa Ngqawana", 70503.0,
                        "Success", "2019-05-09"),
                createClient(6816, "https://randomuser.me/api/portraits/men/42.jpg", "Debashis Bhuiyan", 58931.0,
                        "Success", "2019-05-07"),
                createClient(5144, "https://randomuser.me/api/portraits/women/76.jpg", "Jacqueline Asong", 25053.0,
                        "Pending", "2019-04-25"),
                createClient(9800, "https://randomuser.me/api/portraits/men/24.jpg", "Kobus van de Vegte", 7319.0,
                        "Pending", "2019-04-22"),
                createClient(3599, "https://randomuser.me/api/portraits/women/94.jpg", "Mattie Blooman", 18441.0,
                        "Error", "2019-04-17"),
                createClient(3989, "https://randomuser.me/api/portraits/men/76.jpg", "Oea Romana", 33376.0, "Pending",
                        "2019-04-17"),
                createClient(1077, "https://randomuser.me/api/portraits/men/94.jpg", "Stephanus Huggins", 75774.0,
                        "Success", "2019-02-26"),
                createClient(8942, "https://randomuser.me/api/portraits/men/16.jpg", "Torsten Paulsson", 82531.0,
                        "Pending", "2019-02-21"));
        getModel().setItems(clients);
    }

    private Client createClient(int id, String img, String client, double amount, String status, String date) {
        Client c = new Client();
        c.setId(id);
        c.setImg(img);
        c.setClient(client);
        c.setAmount(amount);
        c.setStatus(status);
        c.setDate(date);

        return c;
    }
}
