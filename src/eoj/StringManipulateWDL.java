package eoj;

//����һ����W,D��L��ɵ��ַ�����һ����ʼΪ�յĴ��ַ������������²����������٣����ж��ַ������Ƿ���W���еĻ���ԭ�ַ�����ɾ��һ��W���ӵ����ַ���ĩβ��
//���ж��ַ������Ƿ���D���еĻ�ɾһ��D���ӵ����ַ���ĩβ��Ȼ���L����ͬ�����жϡ�����ѭ������������ֱ��ԭ�ַ���Ϊ�գ����ش��ַ�����
public class StringManipulateWDL {
  public String solution(String string){
      String res = "";
      while(!string.isEmpty()){
          if(string.indexOf('W')!=-1){
              int index = string.indexOf('W');
              string = string.substring(0, index)+string.substring(index+1);
              res+="W";
          }
          if(string.indexOf('D')!=-1){
              int index = string.indexOf('D');
              string = string.substring(0, index)+string.substring(index+1);
              res+="D";
          }

          if(string.indexOf('L')!=-1){
              int index = string.indexOf('L');
              string = string.substring(0, index)+string.substring(index+1);
              res+="L";
          }
      }
      return res;

  }

  public static void main(String[] args){
      String str = "WWLLDDDLLLWWWDDWDWDWDDDDLLLWW";
      StringManipulateWDL sm = new StringManipulateWDL();
      System.out.print(sm.solution(str));
  }
}