package br.com.diogo;

import br.com.diogo.model.Produto;
import br.com.diogo.service.TraduzProdutoService;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import net.suuft.libretranslate.Language;
import net.suuft.libretranslate.Translator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, CsvValidationException {
        List<Produto> produtoList = new CsvToBeanBuilder(new FileReader("src/main/resources/products.csv"))
                .withType(Produto.class).build().parse();
        produtoList.forEach(System.out::println);
        TraduzProdutoService traduzProdutoService = new TraduzProdutoService();
        produtoList.forEach(produto -> {
            traduzProdutoService.traduzir(produto);
            System.out.println(produto);
        });
    }
}
