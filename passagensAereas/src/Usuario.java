import java.util.LinkedList;
import java.util.List;

public class Usuario {

    private String nome;
    private String cpf;
    private String senha;
    private List<Rota> reserva;
    public Boolean autenticado;

    public Usuario(String nome, String cpf, String senha, Boolean autenticado) {
        this.reserva = new LinkedList<>();
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.autenticado = false;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Rota> getReserva() {
        return reserva;
    }

    public void setReserva(List<Rota> reserva) {
        this.reserva = reserva;
    }

    public Rota buscarRota(int id) {
        for (Rota rota : reserva) {
            if (rota.getId() == id) {
                return rota;
            }

        }
        return null;
    }

    public String rotaFormat() {
        String temp = "";
        for (Rota rota : reserva) {
            temp += rota + "\n";
        }
        return temp;
    }
}
