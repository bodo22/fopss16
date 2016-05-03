import Prelude hiding (max, reverse, maximum)

data Bin k = Leaf | Branch (Bin k) k (Bin k)
  deriving Show

preorder :: Bin k -> List k
preorder t = case t of
  Leaf         -> Nil
  Branch l k r -> Cons k
     (append (preorder l ) (preorder r  )  )

nodes :: Bin k -> N
nodes t = case t of
  Leaf         -> S Z
  Branch l k r -> S (plus (nodes l) (nodes r))


data List a = Nil | Cons a (List a) deriving Show

maximum :: List N -> N
maximum xs = case xs of
  Nil        -> Z
  Cons x xs' -> max x (maximum xs')

reverse :: List a -> List a
reverse xs = case xs of
  Nil        -> Nil
  Cons x xs' -> append (reverse xs') (Cons x Nil)

append :: List a -> List a -> List a
append xs ys = case xs of
  Nil        -> ys
  Cons x xs' -> Cons x (append xs' ys)

data N = Z | S N deriving Show

max :: N -> N -> N
max x y = case x of
  Z    -> y
  S x' -> case y of
     Z    -> x
     S y' -> S (max x' y')

times :: N -> N -> N
times x y = case x of
  Z    -> Z
  S x' -> plus y (times x' y)

plus :: N -> N -> N
plus x y = case x of
  Z    -> y
  S x' -> S (plus x' y)