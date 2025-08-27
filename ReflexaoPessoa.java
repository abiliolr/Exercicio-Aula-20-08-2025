import java.util.Objects;
import java.lang.reflect.*;
import javax.swing.JOptionPane;

public class ReflexaoPessoa { 

    public static void setObjectName(Object obj, String nome) {
        if (Objects.isNull(obj)){
            throw new IllegalArgumentException("O objeto (obj) não pode ser nulo.");
        }

        Class<? extends Object> cls = obj.getClass();

        try {
    
            Method method = cls.getMethod("setNome",
					new Class[] { String.class });

			method.invoke(obj, new Object[] { nome });
        }

         catch (NoSuchMethodException ex) {
            throw new IllegalArgumentException(cls.getName() + " não suporta o método setNome(String)");
        } catch (IllegalAccessException ex) {
            throw new IllegalArgumentException("Permissões de acesso insuficientes para executar setNome(String) na classe " + cls.getName());
        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }

    
    public static String getObjectName(Object obj) {
        Class<? extends Object> cls = obj.getClass();
        String ret;
		ret = "";

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
        Class<?> cls;
		String nomeClasse;
        try {
            nomeClasse = JOptionPane.showInputDialog(null, "Digite o nome da classe (Pai, Filho ou Avo)");
            String nome = JOptionPane.showInputDialog(null, "Digite o nome da pessoa");

         
            cls = Class.forName(nomeClasse);

            Constructor<?> ct = cls.getConstructor();
			Object retobj = ct.newInstance();   

            
            ReflexaoPessoa.setObjectName(retobj, nome);

            System.out.println("Classe:"+cls.getName()+" Nome:="+ ReflexaoPessoa.getObjectName(retobj));
           

        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        } catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        } catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
