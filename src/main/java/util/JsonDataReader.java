package util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader {

	public static <T> Object[][] readJsonAsDataProvider(String filePath, TypeReference<List<T>> typeRef) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			List<T> dataList = mapper.readValue(new File(filePath), typeRef);
			Object[][] result = new Object[dataList.size()][1];
			for (int i = 0; i < dataList.size(); i++) {
				result[i][0] = dataList.get(i);
			}

			return result;

		} catch (IOException e) {
			e.printStackTrace();
			return new Object[0][0];
		}

	}

}
