class Node {
	int x, y;
	int origin;
	double total;
	boolean visited;
	SQL ArcSet;

	Node(int index) {
		origin = index;
		total = Double.MAX_VALUE;
		visited = false;
		ArcSet = new SQL();
	}
	void Refresh(int index) {
		origin = index;
		total = Double.MAX_VALUE;
		visited = false;
	}
	void SetXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class ShortestRouteFinder {
	int s = 0;
	double tempDist = 0;
	int tempIndex = 0;
	Node graph[] = new Node[42];

	void Instanciate() {
		for (int x = 0; x < graph.length; x++) {
                    graph[x] = new Node(x);
                    switch (x) { 
			case 0:	
				//property  Building
				graph[x].SetXY(69,7);
				graph[x].ArcSet.add(1);
				graph[x].ArcSet.add(2);
				graph[x].ArcSet.add(7);
				graph[x].ArcSet.add(3);  //di ko to sure kasi pasig na to. pano maglalakad diba ???
				break;

			case 1:	
				//Printing Press Building
				graph[x].SetXY(61,35);
				graph[x].ArcSet.add(0);
				graph[x].ArcSet.add(2);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(3);  //di ko to sure kasi pasig na to. pano maglalakad diba ???
				break;
				
			case 2:	
				//Laboratory High
				graph[x].SetXY(130, 61);
				graph[x].ArcSet.add(0);
				graph[x].ArcSet.add(1);
				break;
			
			case 3:	
				//Pasig River
				graph[x].SetXY(42, 195);
				graph[x].ArcSet.add(0);
				graph[x].ArcSet.add(1);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(45);
				
				//yung sa case 3(pasig yan) di ko sure if
				//dapat pang isama kasi diba maglalakad ka sa tubig?
				
				break;
				
			case 4:	
				//Charlie Del Rosario Hall
				graph[x].SetXY(139, 133);
				graph[x].ArcSet.add(3); // to pasig river(not sure if kelangan isama)
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				
				break;
				
			case 5:	
				//Student Canteen
				graph[x].SetXY(149, 167);
				graph[x].ArcSet.add(3);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(45);
				
				break;
				
			case 6:	
				//University Canteen Sampaguita Building
				graph[x].SetXY(140, 186);
				graph[x].ArcSet.add(1);
				graph[x].ArcSet.add(3);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(32);
				break;
				
			case 7:
				//Water Pump Facility
				graph[x].SetXY(182, 6);
				graph[x].ArcSet.add(0);
				graph[x].ArcSet.add(8);
				graph[x].ArcSet.add(9);
				graph[x].ArcSet.add(10);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(45);
				break;
				
			case 8:
				//R.C. Underground Water Tank
				graph[x].SetXY(186, 21);
				graph[x].ArcSet.add(0);
				graph[x].ArcSet.add(7);
				graph[x].ArcSet.add(9);
				graph[x].ArcSet.add(10);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(45);
				break;
				
			case 9:
				//R.C. Overheard Water Tank 
				graph[x].SetXY(192, 41);
				graph[x].ArcSet.add(7);
				graph[x].ArcSet.add(8);
				graph[x].ArcSet.add(10);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(45);
				break;
				
			case 10:
				//Ninoy Aquino Library and Learning Resources Center
				graph[x].SetXY(242, 66);
				graph[x].ArcSet.add(7);
				graph[x].ArcSet.add(8);
				graph[x].ArcSet.add(9);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				
				break;
				
			case 11:
				//Lagoon
				graph[x].SetXY(258, 142);
				graph[x].ArcSet.add(10);
				graph[x].ArcSet.add(8);
				graph[x].ArcSet.add(9);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(26);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				
				break;
				
			case 12:
				//Amphitheatre
				graph[x].SetXY(244, 192);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(14);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(45);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				
				break;
				
			case 13:
				//P.E. Building
				graph[x].SetXY(311, 56);
				graph[x].ArcSet.add(10);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(14);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(35);
				
				break;
				
			case 14:
				//Tahanan ng Alumni
				graph[x].SetXY(326, 33);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				
				break;
				
			case 15:
				//Swimming Pool
				graph[x].SetXY(365, 40);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(14);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(11);
				break;
				
			case 16:
				//Mabini Monument PUP Obelisk
				graph[x].SetXY(351, 138);
				graph[x].ArcSet.add(10);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(14);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(26);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(45);
				break;
				
			case 17:
				//Freedom Park
				graph[x].SetXY(338, 187);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(14);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(45);
				break;
				
			case 18:
				//Gymnasium and Sports Center
				graph[x].SetXY(454, 40);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(45);
				graph[x].ArcSet.add(37);
				
				break;
				
			case 19:
				//Outdoor Basketball and VolleyBall Court
				graph[x].SetXY(400, 100);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(14);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(10);
				
				break;
				
			case 20:
				//Tennis Court
				graph[x].SetXY(460, 98);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(40);
				
				break;
				
			case 21:
				//Covered Walkaway
				graph[x].SetXY(495, 148);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(26);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(11);
				break;
				
			case 22:
				//Anonas Street
				graph[x].SetXY(343, 517);
				graph[x].ArcSet.add(25);
				graph[x].ArcSet.add(26);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(24);
				break;
				
			case 23:
				//Visitor Information Center
				graph[x].SetXY(553, 62);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(12);
				break;
				
			case 24:
				//Pylon
				graph[x].SetXY(543, 134);
				graph[x].ArcSet.add(22);
				graph[x].ArcSet.add(25);
				graph[x].ArcSet.add(26);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(16);
				
				break;
			
			case 25:
				//RailRoad Track
				graph[x].SetXY(584, 97);
				graph[x].ArcSet.add(22);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(26);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(28);
				break;
				
			case 26:
				//Teresa Street
				graph[x].SetXY(598, 140);
				graph[x].ArcSet.add(22);
				graph[x].ArcSet.add(25);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(21);
				break;
				
			case 27:
				//Main Gate Mural Bass Sculpture
				graph[x].SetXY(543, 148);
				graph[x].ArcSet.add(22);
				graph[x].ArcSet.add(25);
				graph[x].ArcSet.add(26);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(35);
				break;
				
			case 28:
				//Guard House
				graph[x].SetXY(538, 161);
				graph[x].ArcSet.add(22);
				graph[x].ArcSet.add(25);
				graph[x].ArcSet.add(26);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(15);
				break;
				
			case 29:
				//Gazebo
				graph[x].SetXY(415, 158);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(22);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(26);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(10);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(14);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(11);
				break;
				
			case 30:
				//Apolinario Mabini Shrine
				graph[x].SetXY(386, 176);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(14);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(10);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(45);
				graph[x].ArcSet.add(6);
				break;
			
			case 31:
				//Grandstand
				graph[x].SetXY(411, 220);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(25);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(35);
				break;
				
			case 32:
				//Track and Football Oval
				graph[x].SetXY(466, 258);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(25);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(45);
				break;
				
			case 33:
				//Community Building(Gabriela Silang)
				graph[x].SetXY(521, 299);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(25);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(39);
				break;
				
			case 34:
				//Flag Pole
				graph[x].SetXY(335, 202);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(14);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(45);
				break;
				
			case 35:
				//Interfaith Chapel
				graph[x].SetXY(316, 297);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(25);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(45);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(14);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(3);

				break;
				
			case 36:
				//North Wing
				graph[x].SetXY(289, 229);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(45);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(47);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(3);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(18);

				break;
				
			case 37:
				//Nutrition and Food Science Building
				graph[x].SetXY(314, 357);
				graph[x].ArcSet.add(45);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(47);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(14);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(14);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(25);
				
				break;
				
			case 38:
				//East Wing
				graph[x].SetXY(242, 306);
				graph[x].ArcSet.add(45);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(9);
				graph[x].ArcSet.add(8);
				graph[x].ArcSet.add(7);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(15);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(18);
				
				break;
				
			case 39:
				//Dome
				graph[x].SetXY(241, 256);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(45);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(18);
				
				break;
				
			case 40:
				//Main Building
				graph[x].SetXY(239, 239);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(45);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(18);
				
				break;
				
			case 41:
				//West
				graph[x].SetXY(195, 230);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(7);
				graph[x].ArcSet.add(8);
				graph[x].ArcSet.add(9);
				graph[x].ArcSet.add(3);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				break;
			
			case 42:
				//South
				graph[x].SetXY(182, 289);
				graph[x].ArcSet.add(3);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(7);
				graph[x].ArcSet.add(8);
				graph[x].ArcSet.add(9);
				break;

			case 43:
				//Generator Facility
				graph[x].SetXY(162, 330);
				graph[x].ArcSet.add(3);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(7);
				graph[x].ArcSet.add(8);
				graph[x].ArcSet.add(9);
				break;
			
			case 44:
				//PUP Sta.Mesa Ferry Station
				graph[x].SetXY(168, 348);
				graph[x].ArcSet.add(3);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(7);
				graph[x].ArcSet.add(8);
				graph[x].ArcSet.add(9);
				
				break;
			
			case 45:
				//Campus Development and Maintenance building
				graph[x].SetXY(222, 359);
				graph[x].ArcSet.add(3);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(17);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(7);
				graph[x].ArcSet.add(8);
				graph[x].ArcSet.add(9);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(28);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(25);
				
				break;
			
			case 46:
				//Linear Park
				graph[x].SetXY(222, 359);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(7);
				graph[x].ArcSet.add(8);
				graph[x].ArcSet.add(9);
				graph[x].ArcSet.add(3);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(3);
				graph[x].ArcSet.add(1);
				graph[x].ArcSet.add(0);
				
			case 47:
				//Dummy Node
				graph[x].SetXY(113,1);
				graph[x].ArcSet.add(0);
				graph[x].ArcSet.add(1);
				graph[x].ArcSet.add(48);
				graph[x].ArcSet.add(49);
				
			
			case 48:
				//Dummy Node
				graph[x].SetXY(164,20);
				graph[x].ArcSet.add(47);
				graph[x].ArcSet.add(7);
				graph[x].ArcSet.add(8);
				graph[x].ArcSet.add(9);
				graph[x].ArcSet.add(50);
				
			case 49:
				//Dummy Node
				graph[x].SetXY(88,34);
				graph[x].ArcSet.add(47);
				graph[x].ArcSet.add(0);
				graph[x].ArcSet.add(1);
				graph[x].ArcSet.add(2);
				graph[x].ArcSet.add(3);
			
			case 50:
				//Dummy Node
				graph[x].SetXY(190,83);
				graph[x].ArcSet.add(48);
				graph[x].ArcSet.add(9);
				graph[x].ArcSet.add(2);
				graph[x].ArcSet.add(10);
				graph[x].ArcSet.add(51);
				
			
			case 51:
				//Dummy Node
				graph[x].SetXY(203,105);
				graph[x].ArcSet.add(50);
				graph[x].ArcSet.add(10);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(2);
				graph[x].ArcSet.add(52);
				graph[x].ArcSet.add(53);
			
			case 52:
				//Dummy Node
				graph[x].SetXY(211,148);
				graph[x].ArcSet.add(51);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(54);
				
			case 53:
				//Dummy Node
				graph[x].SetXY(177,161);
				graph[x].ArcSet.add(51);
				graph[x].ArcSet.add(54);
				graph[x].ArcSet.add(55);
				graph[x].ArcSet.add(4);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(6);
			
			case 54:
				//Dummy Node
				graph[x].SetXY(208,177);
				graph[x].ArcSet.add(52);
				graph[x].ArcSet.add(53);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(56);
				
			case 55:
				//Dummy Node
				graph[x].SetXY(164,185);
				graph[x].ArcSet.add(53);
				graph[x].ArcSet.add(5);
				graph[x].ArcSet.add(6);
				graph[x].ArcSet.add(56);
				graph[x].ArcSet.add(58);
				graph[x].ArcSet.add(41);
				
			case 56:
				//Dummy Node
				graph[x].SetXY(202,201);
				graph[x].ArcSet.add(54);
				graph[x].ArcSet.add(55);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(57);
			
			case 57:
				//Dummy Node
				graph[x].SetXY(239,222);
				graph[x].ArcSet.add(56);
				graph[x].ArcSet.add(41);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(67);
				
			case 58:
				//Dummy Node
				graph[x].SetXY(132,242);
				graph[x].ArcSet.add(55);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(3);
				graph[x].ArcSet.add(59);
				graph[x].ArcSet.add(43);
				
			case 59:
				//Dummy Node
				graph[x].SetXY(193,353);
				graph[x].ArcSet.add(58);
				graph[x].ArcSet.add(42);
				graph[x].ArcSet.add(43);
				graph[x].ArcSet.add(44);
				graph[x].ArcSet.add(45);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(60);
			
			case 60:
				//Dummy Node
				graph[x].SetXY(261,348);
				graph[x].ArcSet.add(59);
				graph[x].ArcSet.add(61);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(38);
			
			case 61:
				//Dummy Node
				graph[x].SetXY(290,340);
				graph[x].ArcSet.add(60);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(62);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(63);
			
			case 62:
				//Dummy Node
				graph[x].SetXY(342,338);
				graph[x].ArcSet.add(61);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(37);
				graph[x].ArcSet.add(64);
				
			case 63:
				//Dummy Node
				graph[x].SetXY(273,308);
				graph[x].ArcSet.add(61);
				graph[x].ArcSet.add(65);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(35);
			
			case 64:
				//Dummy Node
				graph[x].SetXY(361,304);
				graph[x].ArcSet.add(62);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(66);
				graph[x].ArcSet.add(33);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(32);
				
			case 65:
				//Dummy Node
				graph[x].SetXY(286,264);
				graph[x].ArcSet.add(63);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(39);
				graph[x].ArcSet.add(40);
				graph[x].ArcSet.add(38);
				graph[x].ArcSet.add(67);
				graph[x].ArcSet.add(35);
				
			case 66:
				//Dummy Node
				graph[x].SetXY(358,265);
				graph[x].ArcSet.add(64);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(67);
				graph[x].ArcSet.add(31);
				graph[x].ArcSet.add(32);
				graph[x].ArcSet.add(65);
				
			case 67:
				//Dummy Node
				graph[x].SetXY(316,247);
				graph[x].ArcSet.add(65);
				graph[x].ArcSet.add(35);
				graph[x].ArcSet.add(66);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(34);
				
			case 68:
				//Dummy Node
				graph[x].SetXY(298,191);
				graph[x].ArcSet.add(34);
				graph[x].ArcSet.add(36);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(69);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(12);
				graph[x].ArcSet.add(57);
				
			case 69:
				//Dummy Node
				graph[x].SetXY(337,160);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(68);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(73);
				graph[x].ArcSet.add(74);
				graph[x].ArcSet.add(72);
				graph[x].ArcSet.add(16);
				
			case 70:
				//Dummy Node
				graph[x].SetXY(413,185);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(31);	
				graph[x].ArcSet.add(71);

			case 71:
				//Dummy Node
				graph[x].SetXY(468,153);
				graph[x].ArcSet.add(70);
				graph[x].ArcSet.add(29);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(80);
				graph[x].ArcSet.add(21);
				
			case 72:
				//Dummy Node
				graph[x].SetXY(379,145);
				graph[x].ArcSet.add(30);
				graph[x].ArcSet.add(69);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(73);
				graph[x].ArcSet.add(74);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(71);
				graph[x].ArcSet.add(29);
			
			case 73:
				//Dummy Node
				graph[x].SetXY(340,117);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(69);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(76);
				graph[x].ArcSet.add(75);
				graph[x].ArcSet.add(74);
				
			case 74:
				//Dummy Node
				graph[x].SetXY(352,113);
				graph[x].ArcSet.add(16);
				graph[x].ArcSet.add(73);
				graph[x].ArcSet.add(76);
				graph[x].ArcSet.add(75);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(71);
				graph[x].ArcSet.add(72);
				
			case 75:
				//Dummy Node
				graph[x].SetXY(342,105);
				graph[x].ArcSet.add(19);
				graph[x].ArcSet.add(73);
				graph[x].ArcSet.add(74);
				graph[x].ArcSet.add(76);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(14);
				graph[x].ArcSet.add(15);
				
			case 76:
				//Dummy Node
				graph[x].SetXY(316,100);
				graph[x].ArcSet.add(11);
				graph[x].ArcSet.add(77);
				graph[x].ArcSet.add(78);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(14);
				graph[x].ArcSet.add(75);
				graph[x].ArcSet.add(74);
				graph[x].ArcSet.add(73);
				
			case 77:
				//Dummy Node
				graph[x].SetXY(290,77);
				graph[x].ArcSet.add(76);
				graph[x].ArcSet.add(10);
				graph[x].ArcSet.add(78);
				graph[x].ArcSet.add(13);
				
			case 78:
				//Dummy Node
				graph[x].SetXY(293,58);
				graph[x].ArcSet.add(77);
				graph[x].ArcSet.add(10);
				graph[x].ArcSet.add(79);
				graph[x].ArcSet.add(13);

			case 79:
				//Dummy Node
				graph[x].SetXY(281,27);
				graph[x].ArcSet.add(13);
				graph[x].ArcSet.add(78);
				graph[x].ArcSet.add(10);
				
			case 80:
				//Dummy Node
				graph[x].SetXY(506,146);
				graph[x].ArcSet.add(21);
				graph[x].ArcSet.add(71);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(28);
				
			case 81:
				//Dummy Node
				graph[x].SetXY(494,77);
				graph[x].ArcSet.add(18);
				graph[x].ArcSet.add(20);
				graph[x].ArcSet.add(23);
				graph[x].ArcSet.add(24);
				
			case 82:
				//Dummy Node
				graph[x].SetXY(557,141);
				graph[x].ArcSet.add(27);
				graph[x].ArcSet.add(80);
				graph[x].ArcSet.add(24);
				graph[x].ArcSet.add(22);
				graph[x].ArcSet.add(25);
				graph[x].ArcSet.add(26);
			}
		}
	}	
}
