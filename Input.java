import java.lang.reflect.Field;

public class Input {
    
    public static void main(String[] arg) throws Exception {
        
        //uus objekt
        Calculator arvutus = new Calculator();
        
        //andmete aadress
        arvutus.aadress = "http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
        
        //käivita arvutamise meetod
        arvutus.Calculator();
        
        //uus objekt
        TextOutput tekstifail = new TextOutput();
        
        //kopeeri kõik objekti 'arvutus' väljad ka objektile 'tekstifail'
        Field[] fields = arvutus.getClass().getDeclaredFields();
        for (int i=0; i<fields.length; i++) {
            try {
                Field fieldFrom = arvutus.getClass().getDeclaredField(fields[i].getName());
                Object value = fieldFrom.get(arvutus);
                tekstifail.getClass().getDeclaredField(fields[i].getName()).set(tekstifail, value);
            } catch (IllegalAccessException e) {
                //e.printStackTrace();
            } catch (NoSuchFieldException e) {
                //e.printStackTrace();
            }
        }
        
        //käivita tekstifaili kirjutamise meetod
        tekstifail.TextOutput();
        
        //uus objekt
        ImageOutput pildifail = new ImageOutput();
        
        //kopeeri kõik objekti 'arvutus' väljad ka objektile 'pildifail'
        fields = arvutus.getClass().getDeclaredFields();
        for (int i=0; i<fields.length; i++) {
            try {
                Field fieldFrom = arvutus.getClass().getDeclaredField(fields[i].getName());
                Object value = fieldFrom.get(arvutus);
                pildifail.getClass().getDeclaredField(fields[i].getName()).set(pildifail, value);
            } catch (IllegalAccessException e) {
                //e.printStackTrace();
            } catch (NoSuchFieldException e) {
                //e.printStackTrace();
            }
        }
        
        //käivita pildifaili kirjutamise meetod
        pildifail.ImageOutput();
    }
}