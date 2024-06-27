package interfaces;

import java.sql.SQLException;
import java.util.List;
import model.Contato;

public interface Interface {
    void adiciona(Contato contato) throws SQLException;
    List<Contato> getLista() throws SQLException;
    List<Contato> buscarContatosPorInicial(String inicial) throws SQLException;
    Contato buscarContatoPorId(long id) throws SQLException;
    void atualizarContato(Contato contato) throws SQLException;
    void removerContato(long id) throws SQLException;
}
