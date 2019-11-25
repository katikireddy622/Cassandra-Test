package info.katikireddy622.cassandratest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

	// bucket size is 888
	public static HashMapImp<String, Double> hm = new HashMapImp<>(888);

	@GetMapping("/getvalue/{key}")
	public String retriveData(@PathVariable String key) {

		Double val = hm.get(key);
		if (val == null) {
			return "No Data Found";
		}

		return val.toString();
	}

	@PostMapping("/insert")
	public String insertData(@RequestParam(value = "key") String key, @RequestParam(value = "value") Double value) {

		hm.put(key, value);
		return "Inserted";
	}

}
