package entities;

public class Funcionarios {
    private String nome;
    private String email;
    private Double salario;

    public Funcionarios(String nome, String email, Double salario) {
        this.nome = nome;
        this.email = email;
        this.salario = salario;
    }

    public Funcionarios(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String toString(){
        return "Nome: " + getNome() + " Email: " + getEmail() + String.format(" R$ %.2f", getSalario());
    }
}
