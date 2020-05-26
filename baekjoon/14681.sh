read a
read b
if [ $a -gt 0 ]
then
	if [ $b -gt 0 ]
	then
		echo "1"
	else
		echo "4"
	fi
else
	if [ $b -gt 0 ]
	then
		echo "2"
	else
		echo "3"
	fi
fi