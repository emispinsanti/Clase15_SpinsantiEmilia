package Practico_15.Practico_15;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class main {

	public static void main(String[] args) {
		
        CsvSchema esquema = CsvSchema.builder()
                .addColumn("nombre")
                .addColumn("peso")
                .addColumn("peso_unidad")
                .addColumn("precio")
                .addColumn("descuento_tipo")
                .addColumn("descuento_cantidad")
                .addColumn("descuento_tope")
                .addColumn("fechaDesde")
                .addColumn("fechaHasta")
                .build()
                .withHeader();

        
        CsvMapper mapper = new CsvMapper();

        try {
            List<Object> objects = mapper.readerFor(Map.class).with(esquema).readValues(new File("C:\\Users\\luisz\\Documents\\A.JAVA UTN\\oferta.cvs")).readAll();
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(objects);
            System.out.println("Producto:" +json);
            
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
    }
}
