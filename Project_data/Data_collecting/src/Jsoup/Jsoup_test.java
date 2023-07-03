import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Jsoup_test {
    public static void main(String[] args) {
        String url = "https://vi.wikipedia.org/wiki/Lịch_sử_Việt_Nam";

        try {
            // Kết nối và tải nội dung của trang Wikipedia
            Document document = Jsoup.connect(url).get();

            // Lấy tiêu đề của trang
            String title = document.title();
            System.out.println("Tiêu đề: " + title);

            // Tạo JSON object lưu trữ dữ liệu
            JSONObject data1 = new JSONObject();
            JSONArray mainSectionsArray = new JSONArray();
            data1.put("TieuDe", title); // Tiêu đề của trang

            // Lấy các mục chính và đoạn văn bản
            Elements mainSections = document.select("h2, h3, p");
            for (Element mainSection : mainSections) {
                String tagName = mainSection.tagName();
                String content = mainSection.text();
                if (tagName.equals("h2") || tagName.equals("h3")) {
                    // Nếu là tiêu đề h2 hoặc h3 (các mục chính)
                    JSONObject section = new JSONObject();
                    section.put("TieuDe", content);
                    section.put("DoanVan", new JSONArray());
                    mainSectionsArray.add(section);
                } else if (tagName.equals("p")) {
                    // Nếu là đoạn văn bản
                    JSONArray paragraphsArray = (JSONArray) ((JSONObject) mainSectionsArray.get(mainSectionsArray.size() - 1)).get("DoanVan");
                    paragraphsArray.add(content);
                }
            }
            data1.put("MucChinhVaDoanVan", mainSectionsArray); // Danh sách các mục chính và đoạn văn bản

            // Lưu dữ liệu vào file JSON
            try (FileWriter file = new FileWriter(title + ".json")) {
                file.write(data1.toJSONString());
                System.out.println("Lưu dữ liệu vào file " + title + ".json thành công!");
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Tạo JSON object lưu trữ dữ liệu từ khóa và link
            JSONObject data2 = new JSONObject();
            JSONArray keywordsArray = new JSONArray();

            // Lấy các từ khóa và link đính kèm
            Elements links = document.select("a[href]");
            for (Element link : links) {
                String keyword = link.text();
                String linkUrl = link.attr("abs:href");
                if (!keyword.isEmpty() && !linkUrl.isEmpty()) {
                    JSONObject keywordObj = new JSONObject();
                    keywordObj.put("TuKhoa", keyword);
                    keywordObj.put("Link", linkUrl);
                    keywordsArray.add(keywordObj);
                }
            }
            data2.put("TuKhoaVaLink", keywordsArray); // Danh sách từ khóa và link

            // Lưu dữ liệu vào file JSON
            try (FileWriter file = new FileWriter(title + "_keywords.json")) {
                file.write(data2.toJSONString());
                System.out.println("Lưu dữ liệu vào file " + title + "_keywords.json thành công!");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
