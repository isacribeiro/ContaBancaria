package atividadejava.dominio;





public class Conta {
    private Integer numero;
    private Titular titular;
    private Double limiteSaque;
    private Double saldo;

    private Long senha;
    private Double valor;

    public void sacar(){

        if(this.getSaldo() <= 0 || this.saldo < this.getValor() ){
            System.out.println("-----------------------------");
            System.out.println("Operação Inválida!");
            System.out.println("Saldo Insuficiente");
            System.out.println("-----------------------------");
        } else if(this.valor > this.getLimiteSaque()) {
            System.out.println("-----------------------------");
            System.out.println("Operação Inválida!");
            System.out.println("Valor máximo de saque atingido! \nSeu limite de saque é até: R$" + this.getLimiteSaque() + " Reais");
            System.out.println("-----------------------------");
        } else {
            System.out.println("-----------------------------");
            System.out.println("Saque realizado com sucesso!");
            System.out.println("Seu saldo é de: R$ " + (this.getSaldo() - this.getValor()) + " Reais");
            System.out.println("-----------------------------");

        }
    }

    public void depositar(){

        System.out.println("-----------------------------");
        System.out.println("Depósito realizado com sucesso!");
        System.out.println("Seu saldo é de: R$ " + (this.getSaldo() + this.getValor()) + " Reais");
        System.out.println("-----------------------------");
    }

    public void consultar(){

        System.out.println("Dados da conta:");
        System.out.println("Titular: " + this.getTitular());
        System.out.println("Numero da conta: " + this.getNumero());
        System.out.println("CPF: " + titular.getCpf());
        System.out.println("Endereço: " + titular.getEndereco());
    }
    public void sair(){

        System.out.println("Até mais, " + titular.getNome() + "!");
    }

    public Conta() {
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public Titular getTitular() {
        return titular;
    }
    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public Long getSenha(){
        return senha;
    }

    public void setSenha(Long senha){
        this.senha = senha;
    }
    public Double getLimiteSaque() {
        return limiteSaque;
    }
    public void setLimiteSaque(Double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
}
