//deixamos a classe abstrata para que ninguém instancie ela, sendo utilizada apenas pela filha


public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected boolean emprestimoRealizado = false;


    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++; //a cada conta criada, soma-se mais um no número do sequencial
        this.cliente = cliente; //determina que o cliente faz parte da determinada conta
    }
    

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;

    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor); 
        contaDestino.depositar(valor);
    }

    public void consultarEmprestimo(double valor){
        if(valor < 500){
            saldo += valor;
            System.out.println("Empréstimo aprovado!");
            System.out.println("O valor já está disponível.\n");
            emprestimoRealizado = true;
        }
        else{
            System.out.println("Não é possível realizar o empréstimo!\n");
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        //System.out.println(String.format("CPF do titular: %s", this.cliente.getCpf()));

        if(emprestimoRealizado == true){
            System.out.println("Um empréstimo foi realizado. Não esqueça de manter suas finanças em ordem.");
        }
        System.out.println("\n");
    }
}
