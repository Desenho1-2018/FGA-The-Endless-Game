
	package game;

	import java.util.ArrayList;

	public class  QuestionColletion {

		 public ArrayList <GameObject> Questions =new ArrayList<GameObject>();
		
		public  void QuestionColletion() {
			
		}

	   
			
		public int sizeQuestions() {
			return Questions.size();
		}
		public GameObject getquestion(int i) {
			 return Questions.get(i);
			
		}
		
		public void setquestion(GameObject question1) {
			Questions.add(question1);
		}
		public void setquestion(int i, int j, String string, int k, GameObjectType other) {
			// TODO Auto-generated method stub
			
		}
	}

