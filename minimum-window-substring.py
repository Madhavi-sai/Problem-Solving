class Solution:
    def minWindow(self, s: str, t: str) -> str:
        dic_t = {}
        for elem in t:
            if elem not in dic_t:
                dic_t[elem] = 1
            else:
                dic_t[elem] += 1
        for elem in s:
            if elem not in dic_t:
                dic_t[elem] = 0        
        dic_s = {}
        minlength =  1000000
        count = 0
        start = 0
        sindex = -1
        for j in range(len(s)):
            if s[j] in dic_s:
                dic_s[s[j]] = dic_s[s[j]] + 1
            else:
                dic_s[s[j]] = 1    
            if dic_s[s[j]] <= dic_t[s[j]]:
                count += 1

            if count == len(t):
                while(dic_s[s[start]] > dic_t[s[start]] or dic_t[s[start]] == 0):
                    dic_s[s[start]] -= 1
                    start += 1
                length = j - start + 1
                if length < minlength:
                    minlength = length
                    sindex = start
        if sindex == -1:
            return ""
        else:
            return s[sindex:sindex + minlength]  



                

