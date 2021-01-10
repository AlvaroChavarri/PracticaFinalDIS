package pkVadin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PeliculaRepository extends JpaRepository<Pelicula,Long>{
    List<Pelicula> findBytituloStartsWithIgnoreCase(String titulo);

}
