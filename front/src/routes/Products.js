import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

function Products() {
  const [products, setProducts] = useState([]);
  const [currentPage, setCurrentPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await fetch(`http://localhost:8080/products?page=${currentPage}`);
        if (response.ok) {
          const data = await response.json();
          setProducts(data.content);
          setTotalPages(data.totalPages);
        } else {
        }
      } catch (error) {
        console.error(error);
      }
    };

    fetchProducts();
  }, [currentPage]);

  const handlePageChange = (newPage) => {
    setCurrentPage(newPage);
  };

  return (
    <div>
      <h1>Product List</h1>
      <ul>
        {products.map((product) => (
          <li key={product.productId}>
          <Link to={`/product/${product.productId}`}>
      <h2>{product.title}</h2></Link>
      <p>{product.description}</p>
      <p>Price: {product.price}</p>
      <img src={product.imgUrl} alt={product.title} style={{
    maxWidth: '100px', 
    height: 'auto',  
  }}/>
    </li>
        ))}
      </ul>
      <div>
        <button
          onClick={() => handlePageChange(currentPage - 1)}
          disabled={currentPage === 0}
        >
          Previous Page
        </button>
        <button
          onClick={() => handlePageChange(currentPage + 1)}
          disabled={currentPage === totalPages - 1}
        >
          Next Page
        </button>
      </div>
    </div>
  );
}

export default Products;