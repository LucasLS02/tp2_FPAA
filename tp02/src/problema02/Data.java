package problema02;

public class Data {
    public String geraData(int dia) {

        StringBuilder resp = new StringBuilder();
        int anos = 1;

        if (dia > 365) {
            do {
                dia -= 365;
                anos++;
            } while (dia > 365);
        }

        if (dia <= 31) {
            resp.append(dia);
            resp.append("/Janeiro");
        } else if (dia <= 59) {
            resp.append(dia - 31);
            resp.append("/Fevereiro");
        } else if (dia <= 90) {
            resp.append(dia - 59);
            resp.append("/Março");
        } else if (dia <= 120) {
            resp.append(dia - 90);
            resp.append("/Abril");
        } else if (dia <= 151) {
            resp.append(dia - 120);
            resp.append("/Maio");
        } else if (dia <= 181) {
            resp.append(dia - 151);
            resp.append("/Junho");
        } else if (dia <= 212) {
            resp.append(dia - 181);
            resp.append("/Julho");
        } else if (dia <= 243) {
            resp.append(dia - 212);
            resp.append("/Agosto");
        } else if (dia <= 273) {
            resp.append(dia - 243);
            resp.append("/Setembro");
        } else if (dia <= 304) {
            resp.append(dia - 273);
            resp.append("/Outubro");
        } else if (dia <= 334) {
            resp.append(dia - 304);
            resp.append("/Novembro");
        } else {
            resp.append(dia - 334);
            resp.append("/Dezembro");
        }

        resp.append(":Ano" + anos);

        return resp.toString();
    }
}
