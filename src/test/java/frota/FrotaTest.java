package frota;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FrotaTest {

    @BeforeEach
    void limparFactory() {
        ModeloVeiculoFactory.limpar();
    }

    @Test
    void deveRetornarVeiculosDaFrota() {
        Frota frota = new Frota();
        frota.incorporar("ABC1D23", 45000, "Fiat", "Strada", "Flex");
        frota.incorporar("EFG2H45", 12000, "Fiat", "Strada", "Flex");
        frota.incorporar("IJK3L67", 78000, "Fiat", "Strada", "Flex");
        frota.incorporar("MNO4P89", 23000, "Volkswagen", "Saveiro", "Flex");

        List<String> saida = Arrays.asList(
                "Veiculo{placa='ABC1D23', marca='Fiat', modelo='Strada', combustivel='Flex', km=45000}",
                "Veiculo{placa='EFG2H45', marca='Fiat', modelo='Strada', combustivel='Flex', km=12000}",
                "Veiculo{placa='IJK3L67', marca='Fiat', modelo='Strada', combustivel='Flex', km=78000}",
                "Veiculo{placa='MNO4P89', marca='Volkswagen', modelo='Saveiro', combustivel='Flex', km=23000}");

        assertEquals(saida, frota.obterVeiculos());
    }

    @Test
    void deveInstanciarApenasUmModeloPorTipo() {
        Frota frota = new Frota();
        frota.incorporar("ABC1D23", 45000, "Fiat", "Strada", "Flex");
        frota.incorporar("EFG2H45", 12000, "Fiat", "Strada", "Flex");
        frota.incorporar("IJK3L67", 78000, "Fiat", "Strada", "Flex");
        frota.incorporar("MNO4P89", 23000, "Volkswagen", "Saveiro", "Flex");

        assertEquals(4, frota.getVeiculos().size());
        assertEquals(2, ModeloVeiculoFactory.getTotalModelos());
    }

    @Test
    void deveCompartilharAMesmaInstanciaDeModelo() {
        Frota frota = new Frota();
        frota.incorporar("ABC1D23", 45000, "Fiat", "Strada", "Flex");
        frota.incorporar("EFG2H45", 12000, "Fiat", "Strada", "Flex");

        assertSame(frota.getVeiculos().get(0).getModeloVeiculo(),
                frota.getVeiculos().get(1).getModeloVeiculo());
    }

    @Test
    void deveUsarInstanciasDiferentesParaModelosDiferentes() {
        Frota frota = new Frota();
        frota.incorporar("ABC1D23", 45000, "Fiat", "Strada", "Flex");
        frota.incorporar("MNO4P89", 23000, "Volkswagen", "Saveiro", "Flex");

        assertNotSame(frota.getVeiculos().get(0).getModeloVeiculo(),
                frota.getVeiculos().get(1).getModeloVeiculo());
    }

    @Test
    void deveManterQuilometragemIndividualComModeloCompartilhado() {
        Frota frota = new Frota();
        frota.incorporar("ABC1D23", 45000, "Fiat", "Strada", "Flex");
        frota.incorporar("EFG2H45", 12000, "Fiat", "Strada", "Flex");

        assertEquals("Veiculo{placa='ABC1D23', marca='Fiat', modelo='Strada', combustivel='Flex', km=45000}",
                frota.getVeiculos().get(0).obterVeiculo());
        assertEquals("Veiculo{placa='EFG2H45', marca='Fiat', modelo='Strada', combustivel='Flex', km=12000}",
                frota.getVeiculos().get(1).obterVeiculo());
    }

    @Test
    void deveDiferenciarModelosPeloCombustivel() {
        Frota frota = new Frota();
        frota.incorporar("ABC1D23", 45000, "Fiat", "Strada", "Flex");
        frota.incorporar("QRS5T01", 30000, "Fiat", "Strada", "Diesel");

        assertNotSame(frota.getVeiculos().get(0).getModeloVeiculo(),
                frota.getVeiculos().get(1).getModeloVeiculo());
        assertEquals(2, ModeloVeiculoFactory.getTotalModelos());
        assertEquals("Veiculo{placa='QRS5T01', marca='Fiat', modelo='Strada', combustivel='Diesel', km=30000}",
                frota.getVeiculos().get(1).obterVeiculo());
    }
}
