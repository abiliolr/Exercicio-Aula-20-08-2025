
import java.lang.reflect.*;
import javax.swing.JOptionPane;

public class ReflexaoPessoa { 

    public static void setObjectName(Object obj, String nome) {
        if (obj == null) {
            throw new IllegalArgumentException("O objeto (obj) não pode ser nulo.");
        }

        Class<?> cls = obj.getClass();

        try {
    
            Method method = cls.getMethod("setNome", String.class);
            
            method.invoke(obj, nome);

        } catch (NoSuchMethodException ex) {
            throw new IllegalArgumentException(cls.getName() + " não suporta o método setNome(String)");
        } catch (IllegalAccessException ex) {
            throw new IllegalArgumentException("Permissões de acesso insuficientes para executar setNome(String) na classe " + cls.getName());
        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }

    
    public static String getObjectName(Object obj) {
        Class<?> cls = obj.getClass();
        String ret = "";

        try {
          
            Method method = cls.getMethod("getNome");

            ret = (String) method.invoke(obj);

        } catch (NoSuchMethodException ex) {
            throw new IllegalArgumentException(cls.getName() + " não suporta o método getNome()");
        } catch (IllegalAccessException ex) {
            throw new IllegalArgumentException("Permissões de acesso insuficientes para executar getNome() na classe " + cls.getName());
        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
        return ret;
    }

    public static void main(String[] args) {
        try {
            String nomeClasse = JOptionPane.showInputDialog(null, "Digite o nome da classe (Pai, Filho ou Avo)");
            
          
            String nome = JOptionPane.showInputDialog(null, "Digite o nome da pessoa");

         
            Class<?> cls = Class.forName(nomeClasse);

            Constructor<?> ct = cls.getConstructor(); 
            Object retobj = ct.newInstance();       

            
            ReflexaoPessoa.setObjectName(retobj, nome);

            
            String nomeObtido = ReflexaoPessoa.getObjectName(retobj);
            System.out.println("Classe: " + cls.getName() + " | Nome: " + nomeObtido);

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro: A classe '" + e.getMessage() + "' não foi encontrada.", "Erro de Classe", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
