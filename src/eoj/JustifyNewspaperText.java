package eoj;

//见链接：https://leetcode.com/discuss/interview-question/859142/an-interesting-codesignal-problem
//但该链接里的题目描述后给的例子的output是错的，要注意
//Question- Justify Text
//You are moderating a newspaper page, and it's your job to align the text on the page properly. The text is provided to you in the following format:

//lines is an array where each element represents a paragraph, in the form of an array of words;
//aligns is an array representing the alignment of each paragraph from lines - each element is either "LEFT" or "RIGHT";
//width represents the maximum number of characters each line of the output can include.
//Your task is to produce a newspaper page according to the following specifications:

//For each lines[i], include all the words lines[i][j] in order, separated by spaces;
//Include as many words as possible per line (the length of the line must be less than or equal to width), and put the next word on a new line if it would exceed the limit.;
//In the case of excess whitespace, words from lines[i] should be aligned according to aligns[i] - if aligns[i] = "LEFT", the line should have trailing spaces, if aligns[i] = RIGHT, it should have leading spaces;
//Include a border of * characters around all the edges of the result (these characters don't count into width, they are just to make output more pretty).
//It is guaranteed that it is possible to justify the given paragraphs to the newspaper. Return the resulting newspaper page as an array of strings.

//Example

//For lines = [["hello", "world"], ["How", "areYou", "doing"], ["Please look", "and align", "to right"]], aligns = ["LEFT", "RIGHT", "RIGHT"], and width = 16, the output should be

//justifyNewspaperText(lines, aligns, width) = ["**************",
//"hello world ",
//"How areYou doing",
//" Please look",
//" and align",
//" to right",
//"******************"]
//For lines[0] = ["hello", "world"], both words fit on one line with a combined length of 11. Since width = 16, there are 16 - 11 = 5 excess spaces we'll need to add to this line. Because aligns[0] = "LEFT", we align the text to the left by adding the spaces onto the end of the line. So the result for this paragraph is the line "hello world ".

//For lines[1] = ["How", "areYou", "doing"], all three words fit on one line with a length of 16. There are no excess spaces, so the result is "How areYou doing".

//For lines[2] = ["Please look", "and align", "to right"], the words "Please look" and "and align" are too long to combine (the result would have a length of 21 > 16), so we'll start a new line with "and align"; furthermore, the words "and align" and "to right" would have a combined length of 18 > 16 which is also too long, so "to right" will also be on a new line. Since aligns[2] = "RIGHT", all excess spaces are added to the beginning of each line.
import java.util.ArrayList;
import java.util.List;

public class JustifyNewspaperText {
  public static void main(String[] args) {
      JustifyNewspaperText test = new JustifyNewspaperText();
      String[][] lines = {{"hello", "world"}, {"How", "areYou", "doing"}, {"Please look", "and align", "to right", "OK?"}};
      String[] aligns = {"LEFT", "RIGHT", "RIGHT"};
      int width = 16;
      String[] res = test.justifynewspapertext(lines, aligns, width);
      for (String x : res) {
          System.out.println(x);
      }
  }

  public static final String STAR = "*";
  public static final String SPACE = " ";
  public static final String[] POS = {"LEFT", "RIGHT"};

  public String[] justifynewspapertext(String[][] lines, String[] aligns, int width) {
      String bar = repeat(STAR,width + 2);
      List<String> output = new ArrayList<>();
      output.add(bar);
      for (int i = 0; i < lines.length; ++i) {
          String[] line = lines[i];
          List<StringBuilder> sbs = new ArrayList<>();
          sbs.add(new StringBuilder());
          int curSb = 0;
          sbs.get(curSb).append(line[0]);
          for (int j = 1; j < line.length; ++j) {
              String word = line[j];
              if (sbs.get(curSb).length() + word.length() + 1 <= width) {
                  sbs.get(curSb).append(SPACE).append(word);
              } else {
                  sbs.add(new StringBuilder());
                  curSb++;
                  sbs.get(curSb).append(word);
              }
          }
          for (StringBuilder sb : sbs) {
              output.add(getLine(sb, aligns[i], width));
          }
      }
      output.add(bar);
      String[] res = new String[output.size()];
      for (int i = 0; i < res.length; ++i) {
          res[i] = output.get(i);
      }
      return res;
  }

  public String getLine(StringBuilder sb, String pos, int width) {
      int remainingSpace = width - sb.length();
      String res = STAR;
      if (pos.equals(POS[0])) {
          res += sb.toString() + repeat(SPACE, remainingSpace) + STAR;
      } else {
          res += repeat(SPACE, remainingSpace) + sb.toString() + STAR;
      }
      return res;
  }
  private String repeat(String str, int time){
      String newstring = "";
      for(int i=0; i<time; i++){
          newstring+=str;
      }
      return newstring;
  }
}