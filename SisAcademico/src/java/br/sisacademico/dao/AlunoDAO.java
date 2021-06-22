package br.sisacademico.dao;

import br.sisacademico.model.Aluno;
import br.sisacademico.model.Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlunoDAO {

    private static Statement stm;

    public ArrayList<Aluno> getAlunos(Integer... idCurso) throws SQLException {
        ArrayList<Aluno> alunos = new ArrayList<>();
        stm = ConnectionFactory.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        String query = "SELECT"
                + "    \"tb_aluno\".\"idAluno\","
                + "    \"tb_aluno\".\"ra\","
                + "    \"tb_aluno\".\"nome\","
                + "    \"tb_curso\".\"idCurso\","
                + "    \"tb_curso\".\"nome_curso\","
                + "    \"tb_curso\".\"tipo_curso\""
                + "FROM \"tb_aluno\" "
                + "INNER JOIN \"tb_curso\""
                + "        ON \"tb_aluno\".\"idCurso\" = \"tb_curso\".\"idCurso\" ";

        if (idCurso.length != 0) {
            query += "WHERE \"tb_curso\".\"idCurso\" = " + idCurso[0];
        }

        query += " ORDER BY \"nome\"";

        ResultSet resultados = stm.executeQuery(query);

        while (resultados.next()) {
            Aluno a = new Aluno();
            Curso c = new Curso();

            a.setIdAluno(resultados.getInt("idAluno"));
            a.setRa(resultados.getInt("ra"));
            a.setNome(resultados.getString("nome"));

            c.setIdCurso(resultados.getInt("idCurso"));
            c.setNomeCurso(resultados.getString("nome_curso"));
            c.setTipoCurso(resultados.getString("tipo_curso"));

            a.setCurso(c);

            alunos.add(a);
        }

        stm.getConnection().close();

        return alunos;
    }

    public Aluno getAluno(int idAluno) throws SQLException {
        Aluno aluno = new Aluno();
        stm = ConnectionFactory.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        String query = "SELECT * FROM \"tb_aluno\" WHERE \"idAluno\" = " + idAluno;

        ResultSet resultados = stm.executeQuery(query);

        while (resultados.next()) {
            aluno.setIdAluno(resultados.getInt("idAluno"));
            aluno.setRa(resultados.getInt("ra"));
            aluno.setNome(resultados.getString("nome"));
            aluno.setCurso(new Curso(resultados.getInt("idCurso"), null, null));
        }

        stm.getConnection().close();

        return aluno;

    }

    public boolean deleteAluno(int idAluno) {
        try {
            String query = "DELETE FROM \"tb_aluno\" WHERE \"idAluno\" = ?";
            PreparedStatement stm = ConnectionFactory.getConnection().prepareStatement(query);
            stm.setInt(1, idAluno);
            stm.execute();
            stm.getConnection().close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean insereAluno(Aluno aluno) {
        try {
            String query = "INSERT INTO \"tb_aluno\" (\"ra\", \"nome\", \"idCurso\") VALUES(?, ?, ?)";
            PreparedStatement stm = ConnectionFactory.getConnection().prepareStatement(query);
            stm.setInt(1, aluno.getRa());
            stm.setString(2, aluno.getNome());
            stm.setInt(3, aluno.getCurso().getIdCurso());
            stm.execute();
            stm.getConnection().close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean atualizaAluno(int idAluno, int raNovo, String nomeNovo, int cursoNovo) {
        try {
            String query = "UPDATE \"tb_aluno\" SET "
                    + "\"ra\" = ?, "
                    + "\"nome\" = ?, "
                    + "\"idCurso\" = ? "
                    + "WHERE \"idAluno\" = ?";
            PreparedStatement stm = ConnectionFactory.getConnection().prepareStatement(query);
            stm.setInt(1, raNovo);
            stm.setString(2, nomeNovo);
            stm.setInt(3, cursoNovo);
            stm.setInt(4, idAluno);
            stm.execute();
            stm.getConnection().close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
