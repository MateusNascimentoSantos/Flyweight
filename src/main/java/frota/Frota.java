package frota;

import java.util.ArrayList;
import java.util.List;

public class Frota {

    private List<Veiculo> veiculos = new ArrayList<>();

    public void incorporar(String placa, int quilometragem, String marca, String modelo, String combustivel) {
        ModeloVeiculo modeloVeiculo = ModeloVeiculoFactory.getModeloVeiculo(marca, modelo, combustivel);
        Veiculo veiculo = new Veiculo(placa, quilometragem, modeloVeiculo);
        veiculos.add(veiculo);
    }

    public List<String> obterVeiculos() {
        List<String> saida = new ArrayList<String>();
        for (Veiculo veiculo : this.veiculos) {
            saida.add(veiculo.obterVeiculo());
        }
        return saida;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
}
