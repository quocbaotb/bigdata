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
public class COMP_CUSTOM_ID_sv {

	private CSVPrinter csvPrinter;
	private CSVParser csvParser;

	public String DK1_SV() {
		try {
			BufferedReader reader = Files.newBufferedReader(Paths.get("D:\\dataNhac\\report.csv"));
			csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("").withIgnoreHeaderCase().withTrim());
			music music = new music();
			List<music> musics = new ArrayList<>();
			int i = 0;
			for (CSVRecord csvRecord : csvParser) {
				if (csvRecord != null) {
					System.out.println("Record Number - " + csvRecord.getRecordNumber());
					if (!(csvRecord.get(10).isEmpty())) {
						if (!(csvRecord.get(10).equalsIgnoreCase("0"))) {
							if (i <= 1000000) {
								music = new music();
								music.setID(csvRecord.get(0));
								music.setTITLE(csvRecord.get(1));
								music.setARTIST(csvRecord.get(2));
								music.setALBUM(csvRecord.get(3));
								music.setLABEL(csvRecord.get(4));
								music.setISRC(csvRecord.get(5));
								music.setCOMP_ID(csvRecord.get(6));
								music.setCOMP_TITLE(csvRecord.get(7));
								music.setCOMP_ISWC(csvRecord.get(8));
								music.setCOMP_WRITERS(csvRecord.get(9));
								music.setCOMP_CUSTOM_ID(csvRecord.get(10));
								music.setQUANTILE(csvRecord.get(11));
								musics.add(music);
								if (i == 1000000) {
									System.out.println("số dòng thỏa điều kiện 1_0: " + i);
									Writer writer = Files.newBufferedWriter(Paths.get("D:\\dataNhac\\dk1_0.csv"));
									writer.write('\uFEFF');
									csvPrinter = new CSVPrinter(writer, CSVFormat.EXCEL);
									for (music Music : musics) {
										csvPrinter.printRecord(Music.getID(), Music.getTITLE(), Music.getARTIST(),
												Music.getLABEL(), Music.getALBUM(), Music.getISRC(), Music.getCOMP_ID(),
												Music.getCOMP_TITLE(), Music.getCOMP_ISWC(), Music.getCOMP_WRITERS(),
												Music.getCOMP_CUSTOM_ID(), Music.getQUANTILE());
									}
									csvPrinter.flush();
									musics = new ArrayList<>();
								}
							}
							if (i > 1000000) {
								music = new music();
								music.setID(csvRecord.get(0));
								music.setTITLE(csvRecord.get(1));
								music.setARTIST(csvRecord.get(2));
								music.setALBUM(csvRecord.get(3));
								music.setLABEL(csvRecord.get(4));
								music.setISRC(csvRecord.get(5));
								music.setCOMP_ID(csvRecord.get(6));
								music.setCOMP_TITLE(csvRecord.get(7));
								music.setCOMP_ISWC(csvRecord.get(8));
								music.setCOMP_WRITERS(csvRecord.get(9));
								music.setCOMP_CUSTOM_ID(csvRecord.get(10));
								music.setQUANTILE(csvRecord.get(11));
								musics.add(music);
								if (i == 1409574) {
									System.out.println("số dòng thỏa điều kiện 1_1: " + i);
									Writer writer = Files.newBufferedWriter(Paths.get("D:\\dataNhac\\dk1_1.csv"));
									writer.write('\uFEFF');
									csvPrinter = new CSVPrinter(writer, CSVFormat.EXCEL);
									for (music Music : musics) {
										csvPrinter.printRecord(Music.getID(), Music.getTITLE(), Music.getARTIST(),
												Music.getLABEL(), Music.getALBUM(), Music.getISRC(), Music.getCOMP_ID(),
												Music.getCOMP_TITLE(), Music.getCOMP_ISWC(), Music.getCOMP_WRITERS(),
												Music.getCOMP_CUSTOM_ID(), Music.getQUANTILE());
									}
									csvPrinter.flush();
									break;
								}

							}

							i++;
						}
					}

				}
			}
			return "DONE";
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return "ERROR";
	}

}
