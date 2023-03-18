Knave=0
Knight=1
aSays=input("A says: \n")
bSays=input("B says: \n")
isFound=0
A=Knave
B=Knave
for A in [0,1]:
	for B in [0,1]:
		if((A==Knight) == eval(aSays) and (B==Knight) == eval(bSays)):
			print("case"+str(isFound+1))
			if(A):
				print("A is a Knight\n")
			else:
				print("A is a Knave\n")
			if(B):
				print("B is a Knight\n")
			else:
				print("B is a Knave\n")
			isFound+=1
if(isFound==0):
	print("Sorry, there is no satisfied solution\n")
