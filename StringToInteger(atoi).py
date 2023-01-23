class Solution(object):
    def myAtoi(self, s):
        if len(s) == 0:
            return 0
        s = s.strip()
        sign = "+"
        if len(s) == 0:
            return 0
        if s[0] == "-":
            sign = "-"
            s = s[1:]
        elif s[0] == "+":
            s = s[1:]
        i = 0
        modified = "0"
        while(i < len(s) and s[i].isdigit()):
            modified += s[i]
            i += 1

        modified = int(modified)
        if sign == "-":
            modified = -modified
        if modified > 2**31 - 1:
            return 2**31 - 1
        elif modified < -2**31:
            return -2**31
        else:
            return modified    



          
