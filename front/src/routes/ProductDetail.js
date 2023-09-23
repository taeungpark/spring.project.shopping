import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

function ProductDetail() {
    const [product, setProduct] = useState({});
    const { id } = useParams();
    const getProduct = async () => {
        const product = await (
            await fetch(`http://localhost:8080/products/${id}`)
            ).json();
            setProduct(product);
    };

    useEffect(() => {
        getProduct();
    }, [id]);

    return (
        <div>
            <h1>Product Detail</h1>
            {product && (
                <div>
                    <h2>{product.title}</h2>
                    <p>{product.description}</p>
                    <p>Price: {product.price}</p>
                    <img
                        src={product.imgUrl}
                        alt={product.title}
                        style={{ maxWidth: '100px', height: 'auto' }}
                    />
                </div>
            )}
        </div>
    );
}

export default ProductDetail;