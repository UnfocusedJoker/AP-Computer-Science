
public class Magpie4 {
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	private String[] likesAr = new String[] { "" };
	private String[] noLikesAr = new String[] { "" };
	private int likesArLen = likesAr.length;
	private int noLikesArLen = noLikesAr.length;
	private String respFTvShow = "zilch, you don't have one!";
	private String respFColor = "zilch, you don't have one!";
	private String respFMovie = "zilch, you don't have one!";
	private String respFTeam = "zilch, you don't have one!";
	private String respFClass = "zilch, you don't have one!";

	public void printlAr() {
		System.out.print("You like: ");
		for (int i = 0; i < 4; i++) { // only designed with limit of 4 in mind, easily changeable
			if (likesAr.length == 1) {
				System.out.println(likesAr[0]);
				break;
			} else if (likesAr.length == 2) {
				System.out.println(likesAr[0] + " and " + likesAr[1]);
				break;
			} else if (i == likesAr.length - 1) {
				System.out.println("and " + likesAr[i]);
				break;
			} else if (i >= 0 && i < 3) {
				System.out.print(likesAr[i] + ", ");
			}
		}

	}

	public void printnlAr() {
		System.out.print("You don't like: ");
		for (int i = 0; i < 4; i++) {
			if (noLikesAr.length == 1) {
				System.out.println(noLikesAr[0]);
				break;
			}
			if (noLikesAr.length == 2) {
				System.out.println(noLikesAr[0] + " and " + noLikesAr[1]);
				break;
			}
			if (i == noLikesAr.length - 1) {
				System.out.println("and " + noLikesAr[i]);
				break;
			} else if (i >= 0 && i < 3) {
				System.out.print(noLikesAr[i] + ", ");
			}
		}
	}

	public void router(String statement) {
		if (findKeyword(statement, "What do I like?") >= 0) {
			printlAr();
		} else if (findKeyword(statement, "What don't I like?") >= 0) {
			printnlAr();
		} else if (findKeyword(statement, "What TV show is my favorite?") >= 0
				|| findKeyword(statement, "What is my favorite TV show?") >= 0) {
			printFav(statement);
		} else if (findKeyword(statement, "What color is my favorite?") >= 0
				|| findKeyword(statement, "What is my favorite color?") >= 0) {
			printFav(statement);
		} else if (findKeyword(statement, "What movie is my favorite?") >= 0
				|| findKeyword(statement, "What is my favorite movie?") >= 0) {
			printFav(statement);
		} else if (findKeyword(statement, "What sporting team is my favorite?") >= 0
				|| findKeyword(statement, "What is my favorite sporting team?") >= 0) {
			printFav(statement);
		} else if (findKeyword(statement, "What school class is my favorite?") >= 0
				|| findKeyword(statement, "What is my favorite school class?") >= 0) {
			printFav(statement);
		} else if (findKeyword(statement, "What do I like?") == -1
				&& findKeyword(statement, "What don't I like?") == -1) {
			storeInfo(statement);
			System.out.println(getResponse(statement));
		}
	}

	public void printFav(String statement) {
		if (findKeyword(statement, "What TV show is my favorite?") >= 0
				|| findKeyword(statement, "What is my favorite TV show?") >= 0) {
			System.out.println("Your favorite TV show is " + respFTvShow);
		} else if (findKeyword(statement, "What color is my favorite?") >= 0
				|| findKeyword(statement, "What is my favorite color?") >= 0) {
			System.out.println("Your favorite color is " + respFColor);
		} else if (findKeyword(statement, "What movie is my favorite?") >= 0
				|| findKeyword(statement, "What is my favorite movie?") >= 0) {
			System.out.println("Your favorite movie is " + respFMovie);
		} else if (findKeyword(statement, "What sporting team is my favorite?") >= 0
				|| findKeyword(statement, "What is my favorite sporting team?") >= 0) {
			System.out.println("Your favorite sporting team is " + respFTeam);
		} else if (findKeyword(statement, "What school class is my favorite?") >= 0
				|| findKeyword(statement, "What is my favorite school class?") >= 0) {
			System.out.println("Your favorite class in school is " + respFClass);
		}
	}

	public String[] storeInfo(String statement) {
		String[] copy = new String[] { "You have no opinions!!!" }; // existing string value never used
		if ((findKeyword(statement, "like") >= 0 || findKeyword(statement, "appreciate") >= 0
				|| findKeyword(statement, "enjoy") >= 0 || findKeyword(statement, "favorite TV show is") >= 0
				|| findKeyword(statement, "favorite color is") >= 0 || findKeyword(statement, "favorite movie is") >= 0
				|| findKeyword(statement, "favorite sporting team is") >= 0
				|| findKeyword(statement, "favorite school class is") >= 0)
				&& !(findKeyword(statement, "dislike") >= 0 || findKeyword(statement, "hate") >= 0
						|| findKeyword(statement, "don't like") >= 0 || findKeyword(statement, "don't enjoy") >= 0
						|| findKeyword(statement, "don't appreciate") >= 0)) {
			copy = new String[likesArLen];
			for (int i = 0; i < likesAr.length; i++) {
				copy[i] = likesAr[i];
			}
			if (findKeyword(statement, "like") >= 0) {
				copy[likesArLen - 1] = statement.substring(findKeyword(statement, "like") + 5);
			} else if (findKeyword(statement, "appreciate") >= 0) {
				copy[likesArLen - 1] = statement.substring(findKeyword(statement, "appreciate") + 11);
			} else if (findKeyword(statement, "enjoy") >= 0) {
				copy[likesArLen - 1] = statement.substring(findKeyword(statement, "enjoy") + 6);
			} else if (findKeyword(statement, "favorite TV show is") >= 0) {
				copy[likesArLen - 1] = respFTvShow = statement
						.substring(findKeyword(statement, "favorite TV show is") + 20);
			} else if (findKeyword(statement, "favorite color is") >= 0) {
				copy[likesArLen - 1] = respFColor = statement
						.substring(findKeyword(statement, "favorite color is") + 18);
			} else if (findKeyword(statement, "favorite movie is") >= 0) {
				copy[likesArLen - 1] = respFMovie = statement
						.substring(findKeyword(statement, "favorite movie is") + 18);
			} else if (findKeyword(statement, "favorite sporting team is") >= 0) {
				copy[likesArLen - 1] = respFTeam = statement
						.substring(findKeyword(statement, "favorite sporting team is") + 26);
			} else if (findKeyword(statement, "favorite school class is") >= 0) {
				copy[likesArLen - 1] = respFClass = statement
						.substring(findKeyword(statement, "favorite school class is") + 25);
			}
			likesAr = copy;
			if (findKeyword(statement, "like") >= 0 || findKeyword(statement, "appreciate") >= 0
					|| findKeyword(statement, "enjoy") >= 0 || findKeyword(statement, "favorite TV show is") >= 0
					|| findKeyword(statement, "favorite color is") >= 0
					|| findKeyword(statement, "favorite movie is") >= 0
					|| findKeyword(statement, "favorite sporting team is") >= 0
					|| findKeyword(statement, "favorite school class is") >= 0) {
				likesArLen++;
			}
			return likesAr;
		} else if (findKeyword(statement, "dislike") >= 0 || findKeyword(statement, "hate") >= 0
				|| findKeyword(statement, "don't like") >= 0 || findKeyword(statement, "don't enjoy") >= 0
				|| findKeyword(statement, "don't appreciate") >= 0) {
			copy = new String[noLikesArLen];
			for (int i = 0; i < noLikesAr.length; i++) {
				copy[i] = noLikesAr[i];
			}
			if (findKeyword(statement, "dislike") >= 0) {
				copy[noLikesArLen - 1] = statement.substring(findKeyword(statement, "dislike") + 8);
			} else if (findKeyword(statement, "hate") >= 0) {
				copy[noLikesArLen - 1] = statement.substring(findKeyword(statement, "appreciate") + 5);
			} else if (findKeyword(statement, "don't like") >= 0) {
				copy[noLikesArLen - 1] = statement.substring(findKeyword(statement, "don't like") + 11);
			} else if (findKeyword(statement, "don't enjoy") >= 0) {
				copy[noLikesArLen - 1] = statement.substring(findKeyword(statement, "don't enjoy") + 12);
			} else if (findKeyword(statement, "don't appreciate") >= 0) {
				copy[noLikesArLen - 1] = statement.substring(findKeyword(statement, "don't appreciate") + 17);
			}
			noLikesAr = copy;
			if (findKeyword(statement, "dislike") >= 0 || findKeyword(statement, "hate") >= 0
					|| findKeyword(statement, "don't like") >= 0 || findKeyword(statement, "don't enjoy") >= 0
					|| findKeyword(statement, "don't appreciate") >= 0) {
				noLikesArLen++;
			}
			return noLikesAr;
		}
		return copy;
	}

	public String getResponse(String statement) {
		String response = "";
		if (statement.length() == 0) {
			response = "Say something, please.";
		}

		else if (findKeyword(statement, "no") >= 0) {
			response = "Why so negative?";
		} else if (findKeyword(statement, "mother") >= 0 || findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0 || findKeyword(statement, "brother") >= 0) {
			response = "Tell me more about your family.";
		}

		else if (findKeyword(statement, "I want to", 0) >= 0) {
			response = transformIWantToStatement(statement);
		}

		else {
			int psn = findKeyword(statement, "you", 0);

			if (psn >= 0 && findKeyword(statement, "me", psn) >= 0) {
				response = transformYouMeStatement(statement);
			} else {
				response = getRandomResponse();
			}
		}
		return response;
	}

	private String transformIWantToStatement(String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword(statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "What would it mean to " + restOfStatement + "?";
	}

	private String transformYouMeStatement(String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}

		int psnOfYou = findKeyword(statement, "you", 0);
		int psnOfMe = findKeyword(statement, "me", psnOfYou + 3);

		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}

	private int findKeyword(String statement, String goal, int startPos) {
		String phrase = statement.trim();
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

		while (psn >= 0) {
			String before = " ", after = " ";
			if (psn > 0) {
				before = phrase.substring(psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length()) {
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}
			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0))
					&& ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))) {
				return psn;
			}

			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);

		}

		return -1;
	}

	public int findKeyword(String statement, String goal) {
		return findKeyword(statement, goal, 0);
	}

	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		}

		return response;
	}

}