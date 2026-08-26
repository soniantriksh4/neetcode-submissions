class Solution {
    public int evalRPN(String[] tokens) {
        Stack < Integer > st = new Stack<>();
        for( String token : tokens) {

            if ( !token.equals("+") && 
            !token.equals("-") &&
            !token.equals("*") &&
            !token.equals("/")){
                st.push(Integer.parseInt(token));
            }
            else {

                int b = st.pop();
                int a = st.pop();

                if (token.equals("+")) {
                    st.push(a + b);
                }
                else if (token.equals("-")) {
                    st.push(a - b);
                }
                else if (token.equals("*")) {
                    st.push(a * b);
                }
                else {
                    st.push(a / b);
       }
        
    }
}
return st.pop();
    }
}
    

