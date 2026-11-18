package frota;

import java.util.HashMap;
import java.util.Map;

public class ModeloVeiculoFactory {

    private static Map<String, ModeloVeiculo> modelos = new HashMap<>();

    public static ModeloVeiculo getModeloVeiculo(String marca, String modelo, String combustivel) {
        String chave = marca + " " + modelo + " " + combustivel;
        ModeloVeiculo modeloVeiculo = modelos.get(chave);
        if (modeloVeiculo == null) {
            modeloVeiculo = new ModeloVeiculo(marca, modelo, combustivel);
            modelos.put(chave, modeloVeiculo);
        }
        return modeloVeiculo;
    }

    public static int getTotalModelos() {
        return modelos.size();
    }

    public static void limpar() {
        modelos.clear();
    }
}
