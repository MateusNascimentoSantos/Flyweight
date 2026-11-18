package frota;

public class Veiculo {

    private String placa;
    private int quilometragem;
    private ModeloVeiculo modeloVeiculo;

    public Veiculo(String placa, int quilometragem, ModeloVeiculo modeloVeiculo) {
        this.placa = placa;
        this.quilometragem = quilometragem;
        this.modeloVeiculo = modeloVeiculo;
    }

    public ModeloVeiculo getModeloVeiculo() {
        return modeloVeiculo;
    }

    public String obterVeiculo() {
        return "Veiculo{" +
                "placa='" + this.placa + '\'' +
                ", marca='" + modeloVeiculo.getMarca() + '\'' +
                ", modelo='" + modeloVeiculo.getModelo() + '\'' +
                ", combustivel='" + modeloVeiculo.getCombustivel() + '\'' +
                ", km=" + this.quilometragem +
                '}';
    }
}
