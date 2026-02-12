dstfile=/etc/update-motd.d/99-testbed
cat <<'EOF' | sudo tee "$dstfile" > /dev/null
#!/bin/sh
PPID1=`cat /proc/$PPID/status | grep PPid | awk '{ print $2 }'`
PPID2=`cat /proc/$PPID1/status | grep PPid | awk '{ print $2 }'`
current_user=`ps -x | grep $PPID2 | awk '{ print $6 }' |  sed "s/[[:digit:].-]//g"`
other_users=$(who | grep -v "^$current_user " | awk '{print $1}' | sort -u)
host=`cat /etc/hostname`
    echo "====================== Testbed server $host ======================"
    echo "https://www.baeldung.com/linux/ssh-welcome-message"
if [ -z "$other_users" ]; then
    echo "Hello, $current_user. You are the only user currently logged in."
    echo "Please log out when finished running experiments."
else
    echo "Hello, $current_user. THIS TESTBED SERVER MAY BE IN USE."
    echo "There are other users currently logged in: $other_users."
    echo "Before using any high-speed network interfaces, "
    echo "please make sure no active experiments are running "
    echo "or check with the other logged-in users."
fi
    echo "=================================================================="
EOF

sudo chmod a+x $dstfile
