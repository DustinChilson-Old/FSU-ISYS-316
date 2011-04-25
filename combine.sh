#!/bin/sh
rm -f Lab$1Combined.java

cat <<EOF > Lab$1Combined.java 
//==================================================================================
//
//   Dustin Chilson
//   Ferris State University
//   ISYS-316-VL1
//
//==================================================================================
EOF

for f in Lab$1A.java Lab$1B.java Lab$1C.java
do
echo "$f Added"
cat $f >> Lab$1Combined.java
cat <<EOF >> Lab$1Combined.java
//==================================================================================
EOF
done

chmod 400 Lab$1Combined.java

rm *.class
rm *.swp

git add .
git commit -m "Added Lab $1"
git push origin

