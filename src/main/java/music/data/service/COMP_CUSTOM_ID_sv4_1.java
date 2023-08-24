package music.data.service;

import java.io.BufferedReader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import music.data.dtos.music;

@Service
public class COMP_CUSTOM_ID_sv4_1 {

	private CSVPrinter csvPrinter;
	private CSVParser csvParser;

	public String DK4_1_SV() {
		try {
			BufferedReader reader = Files.newBufferedReader(Paths.get("D:\\dataNhac\\report.csv"));
			csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("COMP_ISWC", "COMP_CUSTOM_ID", "ISRC")
					.withIgnoreHeaderCase().withTrim());
			music music = new music();
			List<music> musics = new ArrayList<>();
			int i = 0;
			for (CSVRecord csvRecord : csvParser) {
				System.out.println("Record Number - " + csvRecord.getRecordNumber());
				if (csvRecord != null) {
					if ((!csvRecord.get(8).isEmpty() && !csvRecord.get(8).equalsIgnoreCase("0"))
							|| (!csvRecord.get(10).isEmpty() && !csvRecord.get(10).equalsIgnoreCase("0"))) {
						String ten = csvRecord.get(5);
						System.out.println("tenVN:" + ten);
						if (!ten.isEmpty() && !ten.substring(0, 2).equals("VN")) {
							System.out.println("tenSub:" + ten.substring(0, 2));
							i++;
							System.out.println("vị trí i: " + i);
							music = new music();
							music.setCOMP_ISWC(csvRecord.get(8));
							music.setCOMP_CUSTOM_ID(csvRecord.get(10));
							music.setISRC(csvRecord.get(5));
							musics.add(music);
						}
					}
				}
			}
			Writer writer = Files.newBufferedWriter(Paths.get("D:\\dataNhac\\dk41.csv"));
			writer.write('\uFEFF');
			csvPrinter = new CSVPrinter(writer, CSVFormat.EXCEL);
			for (music Music : musics) {
				csvPrinter.printRecord(Music.getCOMP_ISWC(), Music.getCOMP_CUSTOM_ID(), Music.getISRC());
			}
			csvPrinter.flush();
			return "DONE";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ERROR";
	}
}