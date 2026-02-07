import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapExamples {

  public static void main(String[] args) {
    Map<Integer, String> mapHttpErrors = new HashMap<Integer, String>();
    mapHttpErrors.put(200, "OK");
    mapHttpErrors.put(303, "See Other");
    mapHttpErrors.put(404, "Not Found");
    mapHttpErrors.put(500, "Internal Server Error");
    System.out.println(mapHttpErrors);

    Map<Integer, String> mapErrors = new HashMap<Integer, String>(mapHttpErrors);

    Map<String, String> mapContacts = new LinkedHashMap<String, String>();
    mapContacts.put("0169238175", "Tom");
    mapContacts.put("0904891321", "Peter");
    mapContacts.put("0945678912", "Mary");
    mapContacts.put("0981127421", "John");
    System.out.println(mapContacts);

    Map<String, String> mapLang = new TreeMap<String, String>();
    mapLang.put(".c", "C");
    mapLang.put(".java", "Java");
    mapLang.put(".pl", "Perl");
    mapLang.put(".cs", "C#");
    mapLang.put(".php", "PHP");
    mapLang.put(".cpp", "C++");
    mapLang.put(".xml", "XML");
    System.out.println(mapLang);

    Map<Integer, String> mapHttp = new HashMap<Integer, String>();
    mapHttp.put(400, "Bad Request");
    mapHttp.put(304, "Not Modified");
    mapHttp.put(200, "OK");
    mapHttp.put(301, "Moved Permanently");
    mapHttp.put(500, "Internal Server Error");

    String status301 = mapHttp.get(301);
    System.out.println("301: " + status301);

    if (mapHttp.containsKey(200)) {
      System.out.println("Http status 200");
    }

    if (mapHttp.containsValue("OK")) {
      System.out.println("Found status OK");
    }

    String removedValue = mapHttp.remove(500);
    if (removedValue != null) {
      System.out.println("Removed value: " + removedValue);
    }

    mapHttp.replace(304, "No Changes");

    int size = mapHttp.size();
    System.out.println("Size: " + size);

    if (mapHttp.isEmpty()) {
      System.out.println("No Error");
    } else {
      System.out.println("Have HTTP Errors");
    }

    Map<String, String> mapCountryCodes = new HashMap<String, String>();
    mapCountryCodes.put("1", "USA");
    mapCountryCodes.put("44", "United Kingdom");
    mapCountryCodes.put("33", "France");
    mapCountryCodes.put("81", "Japan");

    Set<String> setCodes = mapCountryCodes.keySet();
    Iterator<String> iterator = setCodes.iterator();
    while (iterator.hasNext()) {
      String code = iterator.next();
      String country = mapCountryCodes.get(code);
      System.out.println(code + " => " + country);
    }

    Collection<String> countries = mapCountryCodes.values();
    for (String country : countries) {
      System.out.println(country);
    }

    Set<Map.Entry<String, String>> entries = mapCountryCodes.entrySet();
    for (Map.Entry<String, String> entry : entries) {
      String code = entry.getKey();
      String country = entry.getValue();
      System.out.println(code + " => " + country);
    }

    mapCountryCodes.forEach(
        (code, country) -> System.out.println(code + " => " + country));

    mapHttpErrors.clear();
    System.out.println("Is map empty? " + mapHttpErrors.isEmpty());

    Map<Integer, String> countryCodesEU = new HashMap<Integer, String>();
    countryCodesEU.put(44, "United Kingdom");
    countryCodesEU.put(33, "France");
    countryCodesEU.put(49, "Germany");

    Map<Integer, String> countryCodesWorld = new HashMap<Integer, String>();
    countryCodesWorld.put(1, "United States");
    countryCodesWorld.put(86, "China");
    countryCodesWorld.put(82, "South Korea");

    System.out.println("Before: " + countryCodesWorld);
    countryCodesWorld.putAll(countryCodesEU);
    System.out.println("After: " + countryCodesWorld);

    TreeMap<String, Double> movieRatings = new TreeMap<String, Double>(Comparator.reverseOrder());
    movieRatings.put("Inception", 8.8);
    movieRatings.put("The Dark Knight", 9.0);
    movieRatings.put("Pulp Fiction", 8.9);
    movieRatings.put("The Matrix", 8.7);

    System.out.println("Movies in descending alphabetical order:");
    for (Map.Entry<String, Double> entry : movieRatings.entrySet()) {
      System.out.println(entry.getKey() + " => " + entry.getValue());
    }
  }
}
