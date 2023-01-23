#User function Template for python3

class Solution:
    def findSubString(self, str):
        unique = set(str)
        start = 0
        count = 0
        minlength = 1000000
        dic = {}
        for j in range(len(str)):
            if str[j] not in dic:
                dic[str[j]] = 1
                count += 1
            else:
                dic[str[j]] += 1
            
            if count == len(unique):
                while(dic[str[start]] > 1):
                    dic[str[start]] -= 1
                    start += 1
                
                length  = j - start + 1
                if length < minlength:
                    minlength = length
        return minlength            
                
                
            
    
    
    


#{ 
 # Driver Code Starts
#Initial Template for Python 3


def main():

    T = int(input())

    while(T > 0):
    	str = input()
    	ob=Solution()
    	print(ob.findSubString(str))
    	
    	T -= 1


if __name__ == "__main__":
    main()

# } Driver Code Ends