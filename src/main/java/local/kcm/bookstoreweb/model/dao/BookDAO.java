package local.kcm.bookstoreweb.model.dao;

import connection.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import local.kcm.bookstoreweb.model.bean.Book;

/**
 *
 * @author Kaylane
 */
public class BookDAO {

    private static final String SQL_INSERT = "INSERT INTO book(titulo, "
            + "autor, preco) "
            + "VALUES (?, ?, ?)";

    private static final String SQL_SELECT_ALL = "SELECT * FROM book ";
    private static final String SQL_SELECT_ID = "SELECT * FROM book "
            + "WHERE id = ?";

    private static final String SQL_UPDATE = "UPDATE book SET titulo = ?, "
            + "autor = ?, preco = ? WHERE id = ?";

    private static final String SQL_DELETE = "DELETE FROM book WHERE id = ?";

    /**
     * Insere um usuario na base de dados Book
     *
     * @param b
     */
    public void create(Book b) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQL_INSERT); // Pega a query e Prepara ela, substituindo as interrogações 
            stmt.setString(1, b.getTitulo());
            stmt.setString(2, b.getAutor());
            stmt.setDouble(3, b.getPreco());

            //Executa a query
            int auxRetorno = stmt.executeUpdate();

            Logger.getLogger(BookDAO.class.getName()).log(Level.INFO, null,
                    "Inclusao: " + auxRetorno);
        } catch (SQLException sQLException) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, sQLException);
        } finally {
            // Encerra a conexão com o banco e o statement.
            MySQLConnection.closeConnection(conn, stmt);
        }
    }

    /**
     * Retorna todos os registros da tabela produto
     *
     * @return
     */
    public List<Book> getResults() {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Book b = null;
        List<Book> listaBooks = null;

        try {
            //Prepara a string de SELECT e executa a query.
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();

            // Carrega os dados do ResultSet rs, converte em Book e
            // Adiciona na lista de retorno.
            listaBooks = new ArrayList<>();

            while (rs.next()) {
                b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitulo(rs.getString("titulo"));
                b.setAutor(rs.getString("autor"));
                b.setPreco(rs.getDouble("preco"));
                listaBooks.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaBooks;
    }

    /**
     * Retorna um produto da tabela produto.
     *
     * @param id IDemtificação do Book
     * @return
     */
    public Book getResultById(int id) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Book b = null;

        try {
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitulo(rs.getString("titulo"));
                b.setAutor(rs.getString("autor"));
                b.setPreco(rs.getDouble("preco"));
            }
        } catch (SQLException sQLException) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, sQLException);
        } finally {
            //Encerra a conexão com o banco e o statement.
            MySQLConnection.closeConnection(conn, stmt, rs);
        }
        return b;
    }

    /**
     * Atualiza um registro na tabela produto.
     *
     * @param b a ser atualizado.
     */
    public void update(Book b) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, b.getTitulo());
            stmt.setString(2, b.getAutor());
            stmt.setDouble(3, b.getPreco());
            stmt.setInt(4, b.getId());

            //Executa a query
            int auxRetorno = stmt.executeUpdate();

            Logger.getLogger(BookDAO.class.getName()).log(Level.INFO, null, "Update: " + auxRetorno);
        } catch (SQLException sQLException) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, sQLException);
        } finally {
            //Encerra a conexão com o banco de dados e o statement.
            MySQLConnection.closeConnection(conn, stmt);
        }
    }

    /**
     * Exclui um produto com base do ID fornecido.
     *
     * @param id Identificação do produto.
     */
    public void delete(int id) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);

            //Executa a query
            int auxRetorno = stmt.executeUpdate();

            Logger.getLogger(BookDAO.class.getName()).log(Level.INFO, null, "Delete: " + auxRetorno);
        } catch (SQLException sQLException) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, sQLException);
        } finally {
            //Encerra a conexão com o banco e o statement.
            MySQLConnection.closeConnection(conn, stmt);
        }
    }
}
