package music.data.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import music.data.service.COMP_CUSTOM_ID_sv;
import music.data.service.COMP_CUSTOM_ID_sv2;
import music.data.service.COMP_CUSTOM_ID_sv3;
import music.data.service.COMP_CUSTOM_ID_sv4;
import music.data.service.COMP_CUSTOM_ID_sv4_1;
import music.data.service.translate;

@RestController
public class COMP_CUSTOM_ID_ĐK1 {

	@Autowired
	COMP_CUSTOM_ID_sv dk1sv;
	
	@Autowired
	COMP_CUSTOM_ID_sv2 dk2sv;
	
	@Autowired
	COMP_CUSTOM_ID_sv3 dk3sv;
	
	@Autowired
	COMP_CUSTOM_ID_sv4 dk4sv;
	
	@Autowired COMP_CUSTOM_ID_sv4_1 dk4_1sv;
	
	@Autowired
	translate translatesv;

	@GetMapping("/dk1")
	public String getCOMP_CUSTOM_ID_ĐK1() throws IOException {
		return dk1sv.DK1_SV();
	}
	
	@GetMapping("/dk2")
	public String getCOMP_CUSTOM_ID_ĐK2() throws IOException {
		return dk2sv.DK2_SV();
	}
	
	@GetMapping("/dk3")
	public String getCOMP_CUSTOM_ID_ĐK3() throws IOException {
		return dk3sv.DK3_SV();
	}
	
	@GetMapping("/dk4")
	public String getCOMP_CUSTOM_ID_ĐK4() throws IOException {
		return dk4sv.DK4_SV();
	}
	
	@GetMapping("/dk41")
	public String getCOMP_CUSTOM_ID_ĐK4_1() throws IOException {
		return dk4_1sv.DK4_1_SV();
	}
	
	@GetMapping("/translate/{test}")
	public String getTranslateVN(@PathVariable String test) throws IOException {
		return translatesv.translateVN(test);
	}


}
