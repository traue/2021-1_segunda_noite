package br.sisacademico.dao;

import br.sisacademico.model.Curso;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class CursoDAO {
    
    private static Statement stm;
    
    public Map<Curso, Integer> getTodosCursoCountAunos() throws SQLException {
        
        Map<Curso, Integer> relatorio = new HashMap<Curso, Integer>();
        stm = ConnectionFactory.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        
        String query = "SELECT \n" +
                "    cursos.\"idCurso\", " +
                "    cursos.\"nome_curso\", " +
                "    cursos.\"tipo_curso\", " +
                "    (SELECT COUNT(*) " +
                "       FROM \"tb_aluno\" " +
                "       WHERE \"idCurso\" = cursos.\"idCurso\") as qtdAlunos " +
                "FROM \"tb_curso\" as cursos";
        
        ResultSet resultados = stm.executeQuery(query);
        
        while(resultados.next()) {
            Curso c = new Curso();
            c.setIdCurso(resultados.getInt("idCurso"));
            c.setNomeCurso(resultados.getString("nome_curso"));
            c.setTipoCurso(resultados.getString("tipo_curso"));
            int qtdAlunos = resultados.getInt("qtdAlunos");
            relatorio.put(c, qtdAlunos);
        }
        
        stm.getConnection().close();
        
        return relatorio;
        //PARAMOS AQUI. FALTA TESTAR
    }
}