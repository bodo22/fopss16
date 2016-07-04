theory Fold
imports Main 
begin

datatype 'a List = Nil | Cons 'a "('a List)"

fun append :: "'a List \<Rightarrow> 'a List \<Rightarrow> 'a List" where
  "append Nil ys = ys" |
  "append (Cons x xs) ys = Cons x (append xs ys)"

lemma app_xs_nil : "append xs Nil = xs" 
proof (induction xs) qed auto

lemma app_assoc : "append (append xs ys) zs = append xs (append ys zs)"
proof (induction xs) qed auto

fun reverse :: "'a List \<Rightarrow> 'a List" where
  "reverse Nil = Nil" | "reverse (Cons x xs) = append (reverse xs) (Cons x Nil)"

fun foldr :: "('a \<Rightarrow> 'r \<Rightarrow> 'r) \<Rightarrow> 'r \<Rightarrow> 'a List \<Rightarrow> 'r" where
  "foldr f a Nil = a" |
  "foldr f a (Cons x xs) = f x (foldr f a xs)"

fun foldl :: "('r \<Rightarrow> 'a \<Rightarrow> 'r) \<Rightarrow> 'r \<Rightarrow> 'a List \<Rightarrow> 'r" where
  "foldl f a Nil = a" |
  "foldl f a (Cons x xs) = foldl f (f a x) xs"

lemma ra : "foldr f a (append xs ys) = foldr f (foldr f a ys) xs"
proof (induction xs arbitrary: ys)
  case Nil show ?case by (simp add: app_xs_nil)
  case Cons show ?case by (simp add: Cons.IH)
qed 

lemma lr : "foldl f a xs = foldr ( \<lambda> x y . f y x ) a (reverse xs)"
proof (induction xs arbitrary : a)
  case Nil show ?case by simp
  case Cons show ?case
    apply (simp ) 
    apply (simp add : Cons.IH ra)
    done
qed
  
end

