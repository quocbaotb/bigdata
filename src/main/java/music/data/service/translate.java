package music.data.service;

import com.cybozu.labs.langdetect.*;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.gson.Gson;

import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.apache.tika.language.LanguageIdentifier;

@Service
public class translate {

	public String translateVN(String text) {
		String language = text;
		try {
//			DetectorFactory.loadProfile(new File("D:\\language\\profiles"));
//			// load profile data from the "profiles" directory
//			Detector detector = DetectorFactory.create(); // create a language detector
//			detector.append(text); // add text to the detector
//			if (language.isEmpty() || language != null) {
//				detector = DetectorFactory.create(); // create a language detector
//				detector.append(text);
//			}
//			language = detector.detect(); // detect the language
//			System.out.println("Detected language: " + language);

//			HttpRequest request = HttpRequest.newBuilder()
//					.uri(URI.create("https://api.nlpcloud.io/v1/python-langdetect/langdetection"))
//					.header("Authorization", "Token 1864e050644137fac19b395b7298560bc32e775e")
//					.header("Content-Type", "application/json")
//					.method("POST", HttpRequest.BodyPublishers.ofString("{\"text\":\" " + language + ".\"}")).build();
//			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
//					HttpResponse.BodyHandlers.ofString());
//			System.out.println(response.body().toString());
//
//			language = response.body().toString();
			
			Translate translate = TranslateOptions.getDefaultInstance().getService();
			Translation translation = translate.translate(language);
			language = translation.getSourceLanguage();
			System.out.println("Detected language: " + language);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return language;
	}

}
