public class PilhaDeExecucao {
    public static void metodo1() {
        System.out.println("[Inicio] - metodo1");

        metodo2();

        System.out.println("[Fim] - metodo1");
    }

    public static void metodo2() {
        System.out.println("[Inicio] - metodo2");
        //        Usuario usuario = new Usuario("Vinicius");
        Usuario usuario = null;
//        try {
            System.out.println(usuario.nome);
//        } catch (NullPointerException ex){
//            throw new Exception(ex.getMessage());
            System.out.println("usuário não encontrado");
//        }
        System.out.println("[Fim] - metodo2");
    }

    public static void main(String[] args) {
        System.out.println("[Inicio] - main");
        try{
            metodo1();

        } catch (NullPointerException ex){
            System.out.println("usuário não encontrado");
        }

        System.out.println("[Fim] - main");
    }
}

class Usuario {
    public String nome;
    public Usuario(String nome) {
        this.nome = nome;
    }
}
