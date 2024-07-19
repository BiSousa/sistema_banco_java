//uma interface é uma classe abstrata que OBRIGA todas as que tiverem implementado ela
//a utilizarem os métodos dela

public interface IConta {

    //TODOS os métodos são públicos, por isso não necessita reescrever
    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, Conta contaDestino); //está esperando uma conta corrente ou poupança ser passada

    void visualizarExtrato();
}
