public class Main {

    public static void main(String[] args) {
        Cliente beatriz = new Cliente();
        beatriz.setNome("Beatriz");
        //beatriz.setCpf("123-4");

        Conta cc = new ContaCorrente(beatriz);
        Conta poupanca = new ContaPoupanca(beatriz);

        cc.depositar(100);
        cc.transferir(100, poupanca);

        cc.visualizarExtrato();
        poupanca.visualizarExtrato();
    }
}
