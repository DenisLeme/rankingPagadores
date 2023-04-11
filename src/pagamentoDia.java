import java.util.*;

public class pagamentoDia {

    public static void main(String[] args) {

        // Dados de pagamento das empresas
        Map<String, List<Pagamento>> pagamentosEmpresas = new HashMap<String, List<Pagamento>>();
        pagamentosEmpresas.put("Empresa A", Arrays.asList(
                new Pagamento("2023-04-01", 1),
                new Pagamento("2023-04-03", 1),
                new Pagamento("2023-04-05", 1),
                new Pagamento("2023-04-07", 0),
                new Pagamento("2023-04-09", 1),
                new Pagamento("2023-04-11", 0)
        ));
        pagamentosEmpresas.put("Empresa B", Arrays.asList(
                new Pagamento("2023-04-01", 1),
                new Pagamento("2023-04-03", 1),
                new Pagamento("2023-04-05", 0),
                new Pagamento("2023-04-07", 0),
                new Pagamento("2023-04-09", 1),
                new Pagamento("2023-04-11", 1)
        ));
        pagamentosEmpresas.put("Empresa C", Arrays.asList(
                new Pagamento("2023-04-01", 1),
                new Pagamento("2023-04-03", 0),
                new Pagamento("2023-04-05", 1),
                new Pagamento("2023-04-07", 0),
                new Pagamento("2023-04-09", 1),
                new Pagamento("2023-04-11", 0)
        ));
        pagamentosEmpresas.put("Empresa D", Arrays.asList(
                new Pagamento("2023-04-01", 1),
                new Pagamento("2023-04-03", 1),
                new Pagamento("2023-04-05", 1),
                new Pagamento("2023-04-07", 1),
                new Pagamento("2023-04-09", 0),
                new Pagamento("2023-04-11", 1)
        ));
        pagamentosEmpresas.put("Empresa E", Arrays.asList(
                new Pagamento("2023-04-01", 0),
                new Pagamento("2023-04-03", 0),
                new Pagamento("2023-04-05", 1),
                new Pagamento("2023-04-07", 1),
                new Pagamento("2023-04-09", 0),
                new Pagamento("2023-04-11", 0)
        ));

        // Cálculo da média de pagamentos por empresa
        Map<String, Double> mediaPagamentosEmpresas = new HashMap<String, Double>();
        for (String empresa : pagamentosEmpresas.keySet()) {
            List<Pagamento> pagamentos = pagamentosEmpresas.get(empresa);
            double media = 0;
            for (int i = 0; i < pagamentos.size(); i++) {
                media += pagamentos.get(i).getValor();
            }
            media = media / pagamentos.size();
            mediaPagamentosEmpresas.put(empresa, media);
        }

        // Ordenação do ranking de empresas pela média de pagamentos
        List<Map.Entry<String, Double>> listaRanking = new ArrayList<Map.Entry<String, Double>>(mediaPagamentosEmpresas.entrySet());
        Collections.sort(listaRanking, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // Exibição do ranking das empresas com as informações solicitadas
        System.out.println("Ranking de empresas por média de pagamentos:");
        for (Map.Entry<String, Double> ranking : listaRanking) {
            System.out.println("- " + ranking.getKey() + " (média de " + ranking.getValue() + "):");
            List<Pagamento> pagamentos = pagamentosEmpresas.get(ranking.getKey());
            for (int i = 0; i < pagamentos.size(); i++) {
                Pagamento pagamento = pagamentos.get(i);
                System.out.println("  * " + pagamento.getData() + ": " + pagamento.getValor());
            }
        }
    }

    // Classe interna para representar um pagamento
    private static class Pagamento {
        private String data;
        private int valor;

        public Pagamento(String data, int valor) {
            this.data = data;
            this.valor = valor;
        }

        public String getData() {
            return data;
        }

        public int getValor() {
            return valor;
        }
    }
}

