#include <stdio.h>
#include <stdlib.h>

#define Knave 0
#define Knight 1

int main()
{
	int A = Knave;
	int B = Knave;
	int isFound = 0;
	for (A = Knave; A <= Knight; A++)
	{
		for (B = Knave; B <= Knight; B++)
		{
			if (A ^ (B == Knight) == 0 && B ^ (A != B) == 0)
			{
				if (A) printf("A is a Knight\n");
				else printf("A is a Knave\n");

				if (B) printf("B is a Knight\n");
				else printf("B is a Knave\n");
				isFound++;
			}
		}
	}

	if (isFound == 0) printf("Sorry, there is no satisfied solution\n");
}